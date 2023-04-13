package garousi.dev.taravaz.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import garousi.dev.taravaz.core.design_system.preview.TarAvazPreview
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracksUiState
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSlider
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiState
import garousi.dev.taravaz.home.presentation.banner_slider.BannerSliderUiStateProvider
import garousi.dev.taravaz.home.presentation.latest_tracks.LatestTracks
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracksUiStateProvider
import garousi.dev.taravaz.home.presentation.popular_tracks.PopularTracks
import garousi.dev.taravaz.home.presentation.toolbar.HomeToolbar

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToTrack: (String) -> Unit
) {
    val latestTracksState by viewModel.latestTracks.collectAsStateWithLifecycle()
    val popularTracksState by viewModel.popularTracks.collectAsStateWithLifecycle()
    val bannerSliderState by viewModel.bannerSliderState.collectAsStateWithLifecycle()
    HomeContent(
        latestTracks = latestTracksState,
        bannerSliderState = bannerSliderState,
        popularTracks = popularTracksState,
        onTrackClicked = navigateToTrack
    )
}

@Composable
fun HomeContent(
    latestTracks: HorizontalTracksUiState,
    popularTracks: HorizontalTracksUiState,
    bannerSliderState: BannerSliderUiState,
    onTrackClicked: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HomeToolbar(modifier = Modifier.fillMaxWidth())
        BannerSlider(state = bannerSliderState, onClick = {})
        LatestTracks(state = latestTracks, modifier = Modifier.fillMaxWidth(), onTrackClicked = onTrackClicked)
        PopularTracks(state = popularTracks, modifier = Modifier.fillMaxWidth(), onTrackClicked = onTrackClicked)
    }
}

@Composable
@Preview
fun HomePreview() {
    val tracks = HorizontalTracksUiStateProvider().values
    val banners = BannerSliderUiStateProvider().values
    TarAvazPreview {
        HomeContent(
            latestTracks = tracks.elementAt(1),
            bannerSliderState = banners.elementAt(1),
            popularTracks = tracks.elementAt(1),
            onTrackClicked = {}
        )
    }
}