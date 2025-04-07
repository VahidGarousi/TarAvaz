@file:Suppress("TooGenericExceptionCaught")

package ir.taravaz.home

import androidx.lifecycle.viewModelScope
import ir.taravaz.core.common.constants.TarAvazAppConstants
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.usecase.GetBannersUseCase
import ir.taravaz.core.playlist.domain.model.PlaylistSection
import ir.taravaz.core.playlist.domain.usecase.GetPlaylistSectionUseCase
import ir.taravaz.core.playlist.presentation.model.mapToPlaylistInfoUi
import ir.taravaz.core.track.domain.moel.LatestTracks
import ir.taravaz.core.track.domain.usecase.GetLatestTracksUseCase
import ir.taravaz.core.track.presentation.model.asLatestTracksUi
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.handler.ApiCallHandler
import ir.taravaz.core.ui.model.mapToBannerUis
import ir.taravaz.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(
    private val apiCallHandler: ApiCallHandler,
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
            apiCallHandler.invoke(
                block = {
                    getLatestTracksUseCase()
                },
                onLoading = {
                    _state.update {
                        it.copy(latestTracks = LoadableData.Loading)
                    }
                },
                onSuccess = { latestTracks: LatestTracks ->
                    _state.update {
                        it.copy(latestTracks = LoadableData.Loaded(latestTracks.asLatestTracksUi()))
                    }
                },
                onError = { error: DataError.Network ->
                    _state.update {
                        it.copy(latestTracks = LoadableData.Error(error = error))
                    }
                },
            )
        }
    }

    private fun getPlaylists() {
        viewModelScope.launch {
            apiCallHandler.invoke(
                block = {
                    getPlaylistSectionUseCase()
                },
                onLoading = {
                    _state.update {
                        it.copy(playlistSection = LoadableData.Loading)
                    }
                },
                onSuccess = { playlistSection: PlaylistSection ->
                    _state.update {
                        it.copy(playlistSection = LoadableData.Loaded(playlistSection.mapToPlaylistInfoUi()))
                    }
                },
                onError = { error: DataError.Network ->
                    _state.update {
                        it.copy(playlistSection = LoadableData.Error(error = error))
                    }
                },
            )
        }
    }

    private fun getBanners() {
        viewModelScope.launch {
            apiCallHandler.invoke(
                block = {
                    getBannersUseCase()
                },
                onLoading = {
                    _state.update { it.copy(banners = LoadableData.Loading) }
                },
                onSuccess = { data: List<Banner> ->
                    _state.update {
                        it.copy(
                            banners = LoadableData.Loaded(
                                data = data.mapToBannerUis(),
                            ),
                        )
                    }
                },
                onError = { error ->
                    _state.update {
                        it.copy(
                            banners = LoadableData.Error(
                                error = error,
                            ),
                        )
                    }
                },
            )
        }
    }
}
