package garousi.dev.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import garousi.dev.home.TrackCard

@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val latestTracksState by viewModel.latestTracks.collectAsState()
    HomeContent(latestTracks = latestTracksState)
}

@Composable
fun HomeContent(
    latestTracks: LatestTrackState
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(text = "Latest songs...", modifier = Modifier.align(Alignment.CenterStart))
            TextButton(onClick = { }, modifier = Modifier.align(Alignment.CenterEnd)) {
                Text(text = "All")
            }
        }
        when (latestTracks) {
            LatestTrackState.Loading -> Unit
            is LatestTrackState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(latestTracks.data) { track ->
                        TrackCard(track = track, onClick = {})
                    }
                }
            }
            is LatestTrackState.Failure.Unknown -> Unit
        }
    }
}

@Composable
@Preview
fun HomePreview() {
    HomeContent(LatestTrackState.Loading)
}