package ir.taravaz.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.mapToPlayableBannerUi
import ir.taravaz.core.ui.component.model.mapToPlayablesUi
import ir.taravaz.core.ui.component.model.mapToPlaylistInfoUi
import ir.taravaz.core.ui.util.Constants
import ir.taravaz.home.domain.GetLatestPlayablesUseCase
import ir.taravaz.home.domain.GetPlayableBannersUseCase
import ir.taravaz.home.domain.GetPlaylistSectionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(
    private val getPlayableBannersUseCase: GetPlayableBannersUseCase,
    private val getPlaylistSectionUseCase: GetPlaylistSectionUseCase,
    private val getLatestPlayablesUseCase: GetLatestPlayablesUseCase,
) : ViewModel() {
    private var hasLoadedInitialData = false
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state
        .onStart {
            if (!hasLoadedInitialData) {
                loadInitialData()
                hasLoadedInitialData = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(Constants.STOP_TIMEOUT),
            initialValue = HomeState(),
        )

    private fun loadInitialData() {
        getPlayableBanners()
        getPlaylists()
        getLatestPlayables()
    }

    private fun getLatestPlayables() {
        viewModelScope.launch {
            _state.value = _state.value.copy(latestPlayables = LoadableData.Loading)
            runCatching {
                getLatestPlayablesUseCase()
            }.onSuccess { latestPlayables ->
                _state.update {
                    it.copy(
                        latestPlayables = LoadableData.Loaded(
                            data = latestPlayables.mapToPlayablesUi(),
                        ),
                    )
                }
            }.onFailure { throwable: Throwable ->
                _state.update { it.copy(latestPlayables = LoadableData.Error(throwable = throwable)) }
            }
        }
    }

    private fun getPlaylists() {
        viewModelScope.launch {
            _state.value = _state.value.copy(playlistSection = LoadableData.Loading)
            runCatching {
                getPlaylistSectionUseCase()
            }.onSuccess { playlistSection: PlaylistSection ->
                _state.update {
                    it.copy(
                        playlistSection = LoadableData.Loaded(
                            data = playlistSection.mapToPlaylistInfoUi(),
                        ),
                    )
                }
            }.onFailure { throwable: Throwable ->
                _state.update { it.copy(playlistSection = LoadableData.Error(throwable = throwable)) }
            }
        }
    }

    private fun getPlayableBanners() {
        viewModelScope.launch {
            _state.value = _state.value.copy(playableBanners = LoadableData.Loading)
            runCatching {
                getPlayableBannersUseCase()
            }.onSuccess { playableBanners: List<PlayableBanner> ->
                _state.update {
                    it.copy(
                        playableBanners = LoadableData.Loaded(
                            data = playableBanners.map(PlayableBanner::mapToPlayableBannerUi),
                        ),
                    )
                }
            }.onFailure { throwable ->
                _state.update { it.copy(playableBanners = LoadableData.Error(throwable = throwable)) }
            }
        }
    }
}
