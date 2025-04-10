package ir.taravaz.core.track.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.track.presentation.model.TrackUi

class TrackListPreviewParameterProvider : PreviewParameterProvider<List<TrackUi>> {
    override val values: Sequence<List<TrackUi>> = sequenceOf(
        TrackPreviewParameterProvider().values.toList(),
    )
}
