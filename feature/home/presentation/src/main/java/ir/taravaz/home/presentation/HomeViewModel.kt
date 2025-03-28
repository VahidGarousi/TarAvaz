package ir.taravaz.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.Playlist
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.mapToPlayableBannerUi
import ir.taravaz.core.ui.component.model.mapToPlaylistUi
import ir.taravaz.core.ui.util.Constants
import ir.taravaz.home.domain.GetPlayableBannersUseCase
import ir.taravaz.home.domain.GetPlaylistUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(
    private val getPlayableBannersUseCase: GetPlayableBannersUseCase,
    private val getPlaylistUseCase: GetPlaylistUseCase,
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
        loadPlayableBanners()
        loadPlaylists()
    }

    private fun loadPlaylists() {
        viewModelScope.launch {
            _state.value = _state.value.copy(playlist = LoadableData.Loading)
            runCatching {
                getPlaylistUseCase()
            }.onSuccess { playlists: Playlist ->
                _state.update {
                    it.copy(
                        playlist = LoadableData.Loaded(
                            data = playlists.mapToPlaylistUi(),
                        ),
                    )
                }
            }.onFailure { throwable: Throwable ->
                _state.update { it.copy(playlist = LoadableData.Error(throwable = throwable)) }
            }
        }
    }

    private fun loadPlayableBanners() {
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
