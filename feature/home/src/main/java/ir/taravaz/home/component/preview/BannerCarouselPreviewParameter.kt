package ir.taravaz.home.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.model.BannerUi

internal class BannerCarouselPreviewParameter : PreviewParameterProvider<LoadableData<List<BannerUi>>> {
    override val values: Sequence<LoadableData<List<BannerUi>>> = sequenceOf(
//        LoadableData.Loading,
        LoadableData.Loaded(
            listOf(
                BannerUi(
                    id = 1L,
                    image = "https://placeholder.pics/svg/300",
                    linkType = 0L, // شناسه محصول
                    linkValue = "12345", // شناسه یک محصول نمونه
                ),
                BannerUi(
                    id = 2L,
                    image = "https://placeholder.pics/svg/300",
                    linkType = 1L, // آدرس URL
                    linkValue = "https://example.com/banner1",
                ),
                BannerUi(
                    id = 3L,
                    image = "https://placeholder.pics/svg/300",
                    linkType = 2L, // شناسه مرتب‌سازی
                    linkValue = "popularity", // نمونه‌ای از یک نوع مرتب‌سازی
                ),
            ),
        ),
//        LoadableData.Error(
//            error = DataError.Network.SERVER_ERROR,
//        ),
    )
}
