@file:Suppress("MaxLineLength")

package ir.taravaz.core.ui.component.carousel

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.BannerUi

class PlayableCarouselPreviewParameterProvider : PreviewParameterProvider<LoadableData<List<BannerUi>>> {
    override val values: Sequence<LoadableData<List<BannerUi>>> = sequenceOf(
        LoadableData.Loading,
        LoadableData.Error(
            error = NetworkError.SERVER_ERROR,
        ),
        LoadableData.Loaded(
            data = listOf(
                BannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                BannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                BannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                BannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                BannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
            ),
        ),
    )
}
