package ir.taravaz.core.playlist.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.playlist.presentation.model.PlaylistSectionUi
import ir.taravaz.core.ui.component.LoadableData

class PlaylistSectionPreviewParameterProvider : PreviewParameterProvider<LoadableData<PlaylistSectionUi>> {
    override val values: Sequence<LoadableData<PlaylistSectionUi>> = PlaylistInfoPreviewParameterProvider().values.map { infos ->
        LoadableData.Loaded(
            data = PlaylistSectionUi(
                title = "محبوب ترین ها",
                infos = infos,
            ),
        )
    }
}
