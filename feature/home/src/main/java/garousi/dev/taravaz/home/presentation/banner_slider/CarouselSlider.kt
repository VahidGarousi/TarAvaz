package garousi.dev.taravaz.home.presentation.banner_slider

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import garousi.dev.design_system.debugPlaceholder
import garousi.dev.home.R
import garousi.dev.taravaz.home.domain.model.Banner
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CarouselSlider(
    banners: List<Banner>,
    onClick: (Banner) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    Column(
        modifier = modifier
    ) {
        HorizontalPager(
            pageCount = banners.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 65.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Card(
                onClick = { onClick(banners[page]) },
                modifier = Modifier.graphicsLayer {
                    val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                    scaleX = 0.8f + 0.2f * (1 - pageOffset)
                    scaleY = 0.8f + 0.2f * (1 - pageOffset)
                    alpha = lerp(
                        start = 0.50f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
            ) {
                AsyncImage(
                    model = banners[page].url,
                    contentDescription = null,
                    placeholder = debugPlaceholder(R.drawable.placeholder),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().height(140.dp)
                )
            }
        }
    }
}