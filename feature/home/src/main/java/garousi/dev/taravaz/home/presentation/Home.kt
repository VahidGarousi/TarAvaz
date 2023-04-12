package garousi.dev.taravaz.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import garousi.dev.design_system.theme.TarAvazTheme
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSlider
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiState

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val latestTracksState by viewModel.latestTracks.collectAsStateWithLifecycle()
    val bannerSliderState by viewModel.bannerSliderState.collectAsStateWithLifecycle()
    HomeContent(
        latestTracks = latestTracksState,
        bannerSliderState = bannerSliderState
    )
}

@Composable
fun HomeContent(
    latestTracks: LatestTrackUiState,
    bannerSliderState: BannerSliderUiState
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        BannerSlider(state = bannerSliderState, onClick = {})
        LatestTracks(state = latestTracks)
    }
}

@Composable
@Preview
fun HomePreview() {
    TarAvazTheme {
        HomeContent(
            latestTracks = LatestTrackUiState.Loading,
            bannerSliderState = BannerSliderUiState.Loading
        )
    }
}