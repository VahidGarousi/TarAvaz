package garousi.dev.taravaz.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import garousi.dev.design_system.component.TarAvazBackground
import garousi.dev.design_system.component.TarAvazGradientBackground
import garousi.dev.design_system.theme.TarAvazTheme
import garousi.dev.home.R
import garousi.dev.taravaz.home.domain.model.Track

@Composable
fun LatestTracks(
    state: LatestTrackUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        LatestTracksHeader()
        when (state) {
            LatestTrackUiState.Loading -> LatestTrackLoading()
            is LatestTrackUiState.Success -> LatestTracksSuccess(state.data)
            is LatestTrackUiState.Failure.Unknown -> LatestTracksError(state)
        }
    }
}

@Composable
private fun LatestTracksError(state: LatestTrackUiState.Failure.Unknown) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = state.message,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
private fun LatestTracksSuccess(tracks: List<Track>) {
    LazyRow(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = tracks) { track ->
            Track(
                track = track,
                onClick = {}
            )
        }
    }
}

@Composable
private fun LatestTrackLoading() {
    Box(modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp),
            strokeWidth = 2.dp
        )
    }
}

@Composable
private fun LatestTracksHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = stringResource(R.string.latest_tracks_title),
            modifier = Modifier.align(Alignment.CenterStart),
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(onClick = { }, modifier = Modifier.align(Alignment.CenterEnd)) {
            Text(text = stringResource(R.string.all))
        }
    }
}

@Preview
@Composable
fun LatestTracksPreview(
    @PreviewParameter(LatestTracksStateProvider::class)
    state: LatestTrackUiState
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        TarAvazTheme(
            androidTheme = true
        ) {
            TarAvazBackground(modifier = Modifier.height(200.dp)) {
                TarAvazGradientBackground(
                    modifier = Modifier.height(200.dp)
                ) {
                    LatestTracks(state = state, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}