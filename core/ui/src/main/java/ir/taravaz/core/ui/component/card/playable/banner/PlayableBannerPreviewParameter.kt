package ir.taravaz.core.ui.component.card.playable.banner

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableBannerUi

internal class PlayableBannerPreviewParameter : PreviewParameterProvider<LoadableData<PlayableBannerUi>> {
    override val values: Sequence<LoadableData<PlayableBannerUi>> = sequenceOf(
        LoadableData.Initial,
        LoadableData.Loading,
        LoadableData.Loaded(
            data = PlayableBannerUi(
                cover = "https://google.com/vahid.jpg",
            ),
        ),
        LoadableData.Error(
            throwable = Throwable(
                message = "error",
            ),
        ),
    )
}
