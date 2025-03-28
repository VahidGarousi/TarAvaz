package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.model.PlayableUi

internal class PlayablePreviewParameterProvider : PreviewParameterProvider<PlayableUi> {
    override val values: Sequence<PlayableUi> = sequenceOf(
        PlayableUi(
            id = "",
            artistName = "حجت اشرف زاده",
            cover = "",
            name = "شهرزاد",
        ),
        PlayableUi(
            id = "",
            artistName = "رضا بهرام",
            cover = "",
            name = "گل مریم",
        ),
        PlayableUi(
            id = "",
            artistName = "محسن ابراهیم زاده",
            cover = "",
            name = "منو تو",
        ),
    )
}
