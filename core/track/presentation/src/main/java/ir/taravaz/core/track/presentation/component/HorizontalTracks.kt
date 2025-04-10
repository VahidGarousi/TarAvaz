package ir.taravaz.core.track.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.track.presentation.component.preview.TrackListPreviewParameterProvider
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.ui.component.shimmer.Shimmer

@Composable
fun HorizontalTracks(
    modifier: Modifier = Modifier,
    tracks: List<TrackUi>,
    onTrackClick: (TrackUi) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space16),
    ) {
        items(
            items = tracks,
        ) { track: TrackUi ->
            TrackCard(
                modifier = Modifier.width(TarAvazTheme.spacing.space116),
                track = track,
                onClick = {
                    onTrackClick(track)
                },
            )
        }
    }
}

@Composable
fun LazyPlayableListLoading(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
    ) {
        items(
            count = 5,
        ) {
            Shimmer(
                modifier = Modifier.size(TarAvazTheme.spacing.space96),
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalTracksPreview(
    @PreviewParameter(TrackListPreviewParameterProvider::class)
    parameter: List<TrackUi>,
) {
    TarAvazPreview {
        HorizontalTracks(
            modifier = Modifier.fillMaxWidth(),
            tracks = parameter,
            onTrackClick = {},
        )
    }
}
