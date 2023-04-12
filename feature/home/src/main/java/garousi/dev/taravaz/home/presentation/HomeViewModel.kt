package garousi.dev.taravaz.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracksUiState
import garousi.dev.taravaz.home.domain.use_case.GetBannersResult
import garousi.dev.taravaz.home.domain.use_case.GetBannersUseCase
import garousi.dev.taravaz.home.domain.use_case.GetLatestTracksUseCase
import garousi.dev.taravaz.home.domain.use_case.GetLatestTractsResult
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiState
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

    private val _latestTracks: MutableStateFlow<HorizontalTracksUiState> = MutableStateFlow(HorizontalTracksUiState.Loading)
    val latestTracks = _latestTracks.asStateFlow()

    private val _popularTracks: MutableStateFlow<HorizontalTracksUiState> = MutableStateFlow(HorizontalTracksUiState.Loading)
    val popularTracks = _popularTracks.asStateFlow()

    private val _bannerSlider: MutableStateFlow<BannerSliderUiState> = MutableStateFlow(BannerSliderUiState.Loading)
    val bannerSliderState = _bannerSlider.asStateFlow()


    private fun getLatestTracks() {
        viewModelScope.launch {
            _latestTracks.emit(HorizontalTracksUiState.Loading)
            _popularTracks.emit(HorizontalTracksUiState.Loading)
            delay(2.seconds)
            when (val result = getLatestTracksUseCase()) {
                is GetLatestTractsResult.Success -> {
                    _latestTracks.emit(HorizontalTracksUiState.Success(result.data))
                    _popularTracks.emit(HorizontalTracksUiState.Success(result.data))
                }
                is GetLatestTractsResult.Failure.Unknown -> {
                    _latestTracks.emit(HorizontalTracksUiState.Failure.Unknown(result.message))
                    _popularTracks.emit(HorizontalTracksUiState.Failure.Unknown(result.message))
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