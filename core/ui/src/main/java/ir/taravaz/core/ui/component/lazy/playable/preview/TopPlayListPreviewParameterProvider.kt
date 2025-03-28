package ir.taravaz.core.ui.component.lazy.playable.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableUi
import ir.taravaz.core.ui.component.model.PlayablesUi

class TopPlayListPreviewParameterProvider : PreviewParameterProvider<LoadableData<PlayablesUi>> {
    val playables = PlayablesUi(
        id = "",
        title = "",
        items = listOf(
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
        ),
    )
    override val values: Sequence<LoadableData<PlayablesUi>> = sequenceOf(
        LoadableData.Initial,
        LoadableData.Loading,
        LoadableData.Loaded(
            data = playables,
        ),
        LoadableData.Error(
            throwable = Throwable("Unknown error"),
        ),
    )
}
