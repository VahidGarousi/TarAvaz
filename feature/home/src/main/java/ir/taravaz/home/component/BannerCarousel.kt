@file:Suppress("MagicNumber")

package ir.taravaz.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.banner.Banner
import ir.taravaz.core.ui.component.shimmer.Shimmer
import ir.taravaz.core.ui.model.BannerUi
import ir.taravaz.home.component.preview.BannerCarouselPreviewParameter
import kotlin.math.absoluteValue

@Composable
fun BannerCarousel(
    modifier: Modifier = Modifier,
    banners: LoadableData<List<BannerUi>>,
    onClick: (BannerUi) -> Unit,
) {
    val pagerState = rememberPagerState(
        pageCount = { banners.data?.size ?: 3 },
    )
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 65.dp),
        modifier = modifier.fillMaxSize(),
    ) { page ->
        LoadableComponent(
            loadableData = banners,
            loaded = { playableBannerUi: List<BannerUi> ->
                BannerItem(
                    onClick = onClick,
                    banners = playableBannerUi,
                    page = page,
                    pagerState = pagerState,
                )
            },
            loading = {
                BannerLoading(
                    pagerState = pagerState,
                    page = page,
                )
            },
            failureContent = {
                BannerError(pagerState = pagerState, page = page)
            },
        )
    }
}

@Composable
private fun BannerError(
    pagerState: PagerState,
    page: Int,
) {
    Box(
        modifier = Modifier.graphicsLayer {
            val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
            scaleX = 0.8f + 0.2f * (1 - pageOffset)
            scaleY = 0.8f + 0.2f * (1 - pageOffset)
            alpha = lerp(
                start = 0.50f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f),
            )
        },
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
        )
        ElevatedButton(
            onClick = {
            },
        ) {
            Text("Retry")
        }
    }
}

@Composable
private fun BannerLoading(
    pagerState: PagerState,
    page: Int,
) {
    Box(
        modifier = Modifier.graphicsLayer {
            val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
            scaleX = 0.8f + 0.2f * (1 - pageOffset)
            scaleY = 0.8f + 0.2f * (1 - pageOffset)
            alpha = lerp(
                start = 0.50f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f),
            )
        },
    ) {
        Shimmer(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
        )
    }
}

@Composable
private fun BannerItem(
    onClick: (BannerUi) -> Unit,
    banners: List<BannerUi>,
    page: Int,
    pagerState: PagerState,
) {
    val onBannerClicked = remember {
        {
            onClick(banners[page])
        }
    }
    ElevatedCard(
        modifier = Modifier.graphicsLayer {
            val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
            scaleX = 0.8f + 0.2f * (1 - pageOffset)
            scaleY = 0.8f + 0.2f * (1 - pageOffset)
            alpha = lerp(
                start = 0.50f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f),
            )
        },
        onClick = {
            onBannerClicked
        },
    ) {
        Banner(
            bannerUi = banners[page],
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun BannerCarouselPreview(
    @PreviewParameter(BannerCarouselPreviewParameter::class)
    parameter: LoadableData<List<BannerUi>>,
) {
    TarAvazPreview {
        BannerCarousel(
            banners = parameter,
            onClick = { banner -> },
        )
    }
}
