package garousi.dev.taravaz.home.presentation.latest_tracks

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import garousi.dev.taravaz.core.design_system.preview.TarAvazPreview
import garousi.dev.home.R
import garousi.dev.taravaz.core.ui.R as CoreUiR
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracks
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracksUiState
import garousi.dev.taravaz.core.ui.components.horizontal_tracks.HorizontalTracksUiStateProvider

@Composable
fun LatestTracks(
    state: HorizontalTracksUiState,
    modifier: Modifier = Modifier
) {
    HorizontalTracks(
        modifier = modifier,
        title = R.string.latest_tracks_title,
        actionTitle = R.string.all,
        retryButtonText = CoreUiR.string.retry,
        state = state,
        onClick = { track ->

        }
    )
}


@Preview
@Composable
fun LatestTracksPreview(
    @PreviewParameter(HorizontalTracksUiStateProvider::class)
    state: HorizontalTracksUiState
) {
    TarAvazPreview {
        LatestTracks(
            state = state,
            modifier = Modifier.fillMaxWidth()
        )
    }
}