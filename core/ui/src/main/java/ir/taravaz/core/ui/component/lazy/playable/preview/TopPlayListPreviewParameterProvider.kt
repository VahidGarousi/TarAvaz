package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.LatestTracksUi
import ir.taravaz.core.ui.component.model.TrackUi

class TopPlayListPreviewParameterProvider : PreviewParameterProvider<LoadableData<LatestTracksUi>> {
    val playables = LatestTracksUi(
        id = "",
        title = "",
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
        LoadableData.Initial,
        LoadableData.Loading,
        LoadableData.Loaded(
            data = playables,
        ),
        LoadableData.Error(
            error = DataError.Network.SERVER_ERROR,
        ),
    )
}
