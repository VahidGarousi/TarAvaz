package ir.taravaz.core.ui.component.lazy.playlist.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.model.PlaylistInfoUi

class PlaylistInfoPreviewParameterProvider : PreviewParameterProvider<List<PlaylistInfoUi>> {
    override val values: Sequence<List<PlaylistInfoUi>> = sequenceOf(
        listOf(
            PlaylistInfoUi(
                id = "",
                title = "\uD83C\uDF05 آروم ولی عمیق",
            ),
            PlaylistInfoUi(
                id = "",
                title = "\uD83D\uDE80 برای روزای پرانرژی",
            ),
            PlaylistInfoUi(
                id = "",
                title = "\uD83C\uDF27 بارون و فکرای بی\u200Cپایان",
            ),
            PlaylistInfoUi(
                id = "",
                title = "\uD83C\uDFAD از عشق تا جدایی",
            ),
            PlaylistInfoUi(
                id = "",
                title = "\uD83C\uDF3F ریلکس و بی\u200Cدغدغه",
            ),
        ),
    )
}
