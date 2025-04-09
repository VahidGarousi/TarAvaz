package ir.taravaz.feature.track

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.track.presentation.component.preview.TrackPreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData

class TrackStatePreviewParameterProvider : PreviewParameterProvider<TrackState> {
    override val values: Sequence<TrackState> = TrackPreviewParameterProvider().values.take(1).map { track ->
        TrackState(
            trackUi = LoadableData.Loaded(track),
        )
    }
}
