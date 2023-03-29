package garousi.dev.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import garousi.dev.design_system.theme.TarAvazTheme

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val latestTracksState by viewModel.latestTracks.collectAsState()
    HomeContent(latestTracks = latestTracksState)
}

@Composable
fun HomeContent(
    latestTracks: LatestTrackUiState
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LatestTracks(
            state = latestTracks
        )
    }
}

@Composable
@Preview
fun HomePreview() {
    TarAvazTheme {
        HomeContent(LatestTrackUiState.Loading)
    }
}