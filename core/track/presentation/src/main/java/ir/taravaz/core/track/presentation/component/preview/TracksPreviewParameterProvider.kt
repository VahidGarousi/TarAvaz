package ir.taravaz.core.track.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.track.presentation.model.LatestTracksUi
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.ui.component.LoadableData

class TracksPreviewParameterProvider : PreviewParameterProvider<LoadableData<LatestTracksUi>> {
    val tracks = LatestTracksUi(
        id = "",
        title = "جدیدترین ها",
        items = listOf(
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
        ),
    )
    override val values: Sequence<LoadableData<LatestTracksUi>> = sequenceOf(
//        LoadableData.Loading,
        LoadableData.Loaded(
            data = tracks,
        ),
//        LoadableData.Error(
//            error = DataError.Network.SERVER_ERROR,
//        ),
    )
}
