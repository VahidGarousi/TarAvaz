package ir.taravaz.home.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.carousel.PlayableCarouselPreviewParameterProvider
import ir.taravaz.home.presentation.HomeState

internal class HomeStatePreviewParameterProvider : PreviewParameterProvider<HomeState> {
    private val playableCarouselProvider = PlayableCarouselPreviewParameterProvider()
    override val values: Sequence<HomeState> = playableCarouselProvider.values.map { loadableData ->
        HomeState(
            playableBanners = loadableData,
        )
    }
}
