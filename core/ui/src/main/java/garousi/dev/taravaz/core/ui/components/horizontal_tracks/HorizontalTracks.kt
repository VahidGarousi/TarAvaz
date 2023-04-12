package garousi.dev.taravaz.core.ui.components.horizontal_tracks

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import garousi.dev.taravaz.core.model.Track
import garousi.dev.taravaz.core.ui.components.track.DefaultTrack

@Composable
fun HorizontalTracks(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes actionTitle: Int,
    @StringRes retryButtonText: Int,
    state: HorizontalTracksUiState,
    onClick: (Track) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        HorizontalTracksHeader(
            title = title,
            actionTitle = actionTitle
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 170.dp, maxHeight = 180.dp)
        ) {
            when (state) {
                HorizontalTracksUiState.Loading -> HorizontalTracksLoading()
                is HorizontalTracksUiState.Success -> Tracks(tracks = state.data, onClick = onClick)
                is HorizontalTracksUiState.Failure.Unknown -> HorizontalTracksError(
                    message = state.message,
                    retryButtonText = retryButtonText
                )
            }
        }
    }
}

@Composable
private fun Tracks(tracks: List<Track>, onClick: (Track) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = tracks) { track ->
            DefaultTrack(
                track = track,
                onClick = { onClick(track) }
            )
        }
    }
}

@Composable
private fun HorizontalTracksLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp),
            strokeWidth = 2.dp
        )
    }
}

@Composable
private fun HorizontalTracksError(
    message: String,
    retry: () -> Unit = {},
    @StringRes retryButtonText: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error
        )
        TextButton(onClick = retry) {
            Text(
                text = stringResource(retryButtonText),
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Composable
private fun HorizontalTracksHeader(
    @StringRes title: Int,
    @StringRes actionTitle: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = stringResource(title),
            modifier = Modifier.align(Alignment.CenterStart),
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = stringResource(actionTitle))
        }
    }
}