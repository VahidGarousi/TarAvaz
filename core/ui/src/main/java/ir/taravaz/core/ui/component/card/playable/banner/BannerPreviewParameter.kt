package ir.taravaz.core.ui.component.card.playable.banner

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.BannerUi

internal class BannerPreviewParameter : PreviewParameterProvider<LoadableData<BannerUi>> {
    override val values: Sequence<LoadableData<BannerUi>> = sequenceOf(
        LoadableData.Initial,
        LoadableData.Loading,
        LoadableData.Loaded(
            data = BannerUi(
                id = 2L,
                image = "https://placeholder.pics/svg/300",
                linkType = 1L, // آدرس URL
                linkValue = "https://example.com/banner1",
            ),
        ),
        LoadableData.Error(
            error = DataError.Network.SERVER_ERROR,
        ),
    )
}
