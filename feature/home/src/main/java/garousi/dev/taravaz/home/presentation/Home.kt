package garousi.dev.taravaz.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import garousi.dev.design_system.preview.TarAvazPreview
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSlider
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiState
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiStateProvider
import garousi.dev.taravaz.home.presentation.latest_tracks.LatestTrackUiState
import garousi.dev.taravaz.home.presentation.latest_tracks.LatestTracks
import garousi.dev.taravaz.home.presentation.latest_tracks.LatestTracksStateProvider
import garousi.dev.taravaz.home.presentation.toolbar.HomeToolbar

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
        HomeToolbar(modifier = Modifier.fillMaxWidth())
        BannerSlider(state = bannerSliderState, onClick = {})
        LatestTracks(state = latestTracks, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
@Preview
fun HomePreview() {
    val latestTracks = LatestTracksStateProvider().values
    val banners = BannerSliderUiStateProvider().values
    TarAvazPreview {
        HomeContent(
            latestTracks = latestTracks.elementAt(1),
            bannerSliderState = banners.elementAt(1)
        )
    }
}