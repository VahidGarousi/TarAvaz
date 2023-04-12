package garousi.dev.taravaz.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import garousi.dev.taravaz.home.domain.use_case.GetBannersResult
import garousi.dev.taravaz.home.domain.use_case.GetBannersUseCase
import garousi.dev.taravaz.home.domain.use_case.GetLatestTracksUseCase
import garousi.dev.taravaz.home.domain.use_case.GetLatestTractsResult
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiState
import garousi.dev.taravaz.home.presentation.latest_tracks.LatestTrackUiState
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLatestTracksUseCase: GetLatestTracksUseCase,
    private val getBannersUseCase: GetBannersUseCase
) : ViewModel() {

    private val _latestTracks: MutableStateFlow<LatestTrackUiState> = MutableStateFlow(LatestTrackUiState.Loading)
    val latestTracks = _latestTracks.asStateFlow()

    private val _bannerSlider: MutableStateFlow<BannerSliderUiState> = MutableStateFlow(BannerSliderUiState.Loading)
    val bannerSliderState = _bannerSlider.asStateFlow()


    private fun getLatestTracks() {
        viewModelScope.launch {
            _latestTracks.emit(LatestTrackUiState.Loading)
            delay(2.seconds)
            when (val result = getLatestTracksUseCase()) {
                is GetLatestTractsResult.Success -> {
                    _latestTracks.emit(LatestTrackUiState.Success(result.data))
                }
                is GetLatestTractsResult.Failure.Unknown -> {
                    _latestTracks.emit(LatestTrackUiState.Failure.Unknown(result.message))
                }
            }
        }
    }

    private fun getBanners() {
        viewModelScope.launch {
            _bannerSlider.emit(BannerSliderUiState.Loading)
            delay(2.seconds)
            when (val result = getBannersUseCase()) {
                is GetBannersResult.Success -> {
                    _bannerSlider.emit(BannerSliderUiState.Success(result.data))
                }
                is GetBannersResult.Failure.Unknown -> {
                    _bannerSlider.emit(BannerSliderUiState.Failure.Unknown(result.message))
                }
            }
        }
    }

    init {
        getLatestTracks()
        getBanners()
    }
}