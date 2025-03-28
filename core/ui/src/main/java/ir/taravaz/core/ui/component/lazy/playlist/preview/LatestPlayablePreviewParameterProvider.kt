package ir.taravaz.core.ui.component.lazy.playlist.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlaylistSectionUi

class LatestPlayablePreviewParameterProvider : PreviewParameterProvider<LoadableData<PlaylistSectionUi>> {
    override val values: Sequence<LoadableData<PlaylistSectionUi>> = sequenceOf(
        LoadableData.Loaded(
            data = PlaylistSectionUi(
                title = "title",
                infos = PlaylistInfoPreviewParameterProvider().values.first(),
            ),
        ),
    )
}
