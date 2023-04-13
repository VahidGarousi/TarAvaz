package garousi.dev.taravaz.feature.track

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import garousi.dev.taravaz.core.design_system.extension.conditional
import garousi.dev.taravaz.core.design_system.preview.TarAvazPreview
import garousi.dev.taravaz.core.design_system.preview.ThemePreviews

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TrackTabRow(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val tabs = remember {
        mutableStateListOf<String>().apply {
            add("موزیک پلیر")
            add("نظرات")
            add("ترانه های مشابه")
        }
    }
    TrackTabRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        currentPage = pagerState.currentPage,
        updateSelectedTabIndex = {
            selectedTabIndex = it
        },
        tabs = tabs
    )
}

@Composable
private fun TrackTabRow(
    tabs: List<String>,
    currentPage: Int,
    updateSelectedTabIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ScrollableTabRow(
        selectedTabIndex = 0,
        modifier = modifier,
        edgePadding = 16.dp,
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = currentPage == index,
                    onClick = { updateSelectedTabIndex(index) },
                    text = {
                        Text(
                            text = tab,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            color = if (currentPage == index) Color(0XFF0D0F44) else Color(0XFF9E9FB4)
                        )
                    },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .conditional(
                            condition = currentPage == index,
                            ifTrue = {
                                background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0XFF00B2FF),
                                            Color(0XFF00F0FF)
                                        )
                                    ), RoundedCornerShape(16.dp)
                                )
                            }
                        )
                        .height(height = 36.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        },
        divider = {},
        indicator = {},
        containerColor = Color.Transparent
    )
}

@Composable
@ThemePreviews
fun TrackTabRowPreview() {
    TarAvazPreview {
        TrackTabRow()
    }
}