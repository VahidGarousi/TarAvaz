package ir.taravaz.core.playlist.presentation.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.playlist.presentation.model.PlaylistInfoUi

class PlaylistInfoPreviewParameterProvider : PreviewParameterProvider<List<PlaylistInfoUi>> {
    override val values: Sequence<List<PlaylistInfoUi>> = sequenceOf(
        listOf(
            PlaylistInfoUi(
                id = "",
                title = " آروم ولی عمیق",
            ),
            PlaylistInfoUi(
                id = "",
                title = " برای روزای پرانرژی",
            ),
            PlaylistInfoUi(
                id = "",
                title = " بارون و فکرای بی پایان",
            ),
            PlaylistInfoUi(
                id = "",
                title = " از عشق تا جدایی",
            ),
            PlaylistInfoUi(
                id = "",
                title = " ریلکس و بی دغدغه",
            ),
        ),
    )
}
