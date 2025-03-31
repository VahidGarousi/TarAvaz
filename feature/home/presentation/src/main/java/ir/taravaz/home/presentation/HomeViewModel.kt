@file:Suppress("TooGenericExceptionCaught")

package ir.taravaz.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.common.constants.TarAvazAppConstants
import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.map
import ir.taravaz.core.ui.component.model.mapToPlayableBannerUi
import ir.taravaz.core.ui.component.model.mapToPlayablesUi
import ir.taravaz.core.ui.component.model.mapToPlaylistInfoUi
import ir.taravaz.home.domain.GetBannersUseCase
import ir.taravaz.home.domain.GetLatestTracksUseCase
import ir.taravaz.home.domain.GetPlaylistSectionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(
    private val getBannersUseCase: GetBannersUseCase,
    private val getPlaylistSectionUseCase: GetPlaylistSectionUseCase,
    private val getLatestTracksUseCase: GetLatestTracksUseCase,
) : BaseViewModel() {
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
            started = SharingStarted.WhileSubscribed(TarAvazAppConstants.STOP_TIMEOUT),
            initialValue = HomeState(),
        )

    private fun loadInitialData() {
        getBanners()
        getPlaylists()
        getLatestTracks()
    }

    private fun getLatestTracks() {
        viewModelScope.launch {
            _state.value = _state.value.copy(latestPlayables = LoadableData.Loading)
            val result = getLatestTracksUseCase().map(LatestTracks::mapToPlayablesUi)
            _state.update {
                it.copy(
                    latestPlayables = result,
                )
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
                _state.update { it.copy(playlistSection = LoadableData.Error(error = NetworkError.SERVER_ERROR)) }
            }
        }
    }

    private fun getBanners() {
        viewModelScope.launch {
            _state.value = _state.value.copy(banners = LoadableData.Loading)
            runCatching {
                getBannersUseCase()
            }.onSuccess { playableBanners: List<PlayableBanner> ->
                _state.update {
                    it.copy(
                        banners = LoadableData.Loaded(
                            data = playableBanners.map(PlayableBanner::mapToPlayableBannerUi),
                        ),
                    )
                }
            }.onFailure { throwable ->
                _state.update { it.copy(banners = LoadableData.Error(error = NetworkError.SERVER_ERROR)) }
            }
        }
    }
}

abstract class BaseViewModel : ViewModel()
