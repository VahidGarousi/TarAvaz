package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.model.TrackUi

internal class PlayablePreviewParameterProvider : PreviewParameterProvider<TrackUi> {
    override val values: Sequence<TrackUi> = sequenceOf(
        TrackUi(
            id = "",
            artistName = "حجت اشرف زاده",
            imageUrl = "",
            name = "شهرزاد",
        ),
        TrackUi(
            id = "",
            artistName = "رضا بهرام",
            imageUrl = "",
            name = "گل مریم",
        ),
        TrackUi(
            id = "",
            artistName = "محسن ابراهیم زاده",
            imageUrl = "",
            name = "منو تو",
        ),
    )
}
