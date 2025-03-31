package ir.taravaz.core.ui.component.lazy.playable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.component.lazy.playable.preview.LazyPlayableListPreviewParameterProvider
import ir.taravaz.core.ui.component.model.TrackUi
import ir.taravaz.core.ui.component.shimmer.Shimmer

@Composable
fun LazyPlayableList(
    modifier: Modifier = Modifier,
    latestPlayables: List<TrackUi>,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
    ) {
        items(
            items = latestPlayables,
        ) { playableItem: TrackUi ->
            Playable(
                modifier = Modifier.size(TarAvazTheme.spacing.space96),
                playable = playableItem,
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
private fun LazyPlayableListPreview(
    @PreviewParameter(LazyPlayableListPreviewParameterProvider::class)
    parameter: List<TrackUi>,
) {
    TarAvazPreview {
        LazyPlayableList(
            modifier = Modifier.fillMaxWidth(),
            latestPlayables = parameter,
        )
    }
}
