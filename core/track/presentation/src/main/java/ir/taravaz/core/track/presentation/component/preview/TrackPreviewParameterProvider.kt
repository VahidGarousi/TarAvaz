package ir.taravaz.core.track.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.track.presentation.model.TrackUi

class TrackPreviewParameterProvider : PreviewParameterProvider<TrackUi> {
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
