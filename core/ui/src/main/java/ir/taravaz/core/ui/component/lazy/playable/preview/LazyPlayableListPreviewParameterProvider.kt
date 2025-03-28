package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.model.PlayableUi

class LazyPlayableListPreviewParameterProvider : PreviewParameterProvider<List<PlayableUi>> {
    override val values: Sequence<List<PlayableUi>> = sequenceOf(
        PlayablePreviewParameterProvider().values.toList(),
    )
}
