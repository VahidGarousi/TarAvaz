package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.model.TrackUi

class LazyPlayableListPreviewParameterProvider : PreviewParameterProvider<List<TrackUi>> {
    override val values: Sequence<List<TrackUi>> = sequenceOf(
        PlayablePreviewParameterProvider().values.toList(),
    )
}
