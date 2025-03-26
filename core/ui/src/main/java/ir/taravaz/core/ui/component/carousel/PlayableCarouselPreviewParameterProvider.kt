@file:Suppress("MaxLineLength")

package ir.taravaz.core.ui.component.carousel

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableBannerUi

internal class PlayableCarouselPreviewParameterProvider : PreviewParameterProvider<LoadableData<List<PlayableBannerUi>>> {
    override val values: Sequence<LoadableData<List<PlayableBannerUi>>> = sequenceOf(
        LoadableData.Loaded(
            data = listOf(
                PlayableBannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                PlayableBannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                PlayableBannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                PlayableBannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
                PlayableBannerUi(
                    cover = "https://google.com/vahid.jpg",
                ),
            ),
        ),
    )
}
