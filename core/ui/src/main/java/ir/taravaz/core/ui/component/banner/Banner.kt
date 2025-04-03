package ir.taravaz.core.ui.component.banner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.banner.preview.BannerPreviewParameter
import ir.taravaz.core.ui.component.shimmer.Shimmer
import ir.taravaz.core.ui.model.BannerUi

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    bannerUi: LoadableData<BannerUi>,
) {
    LoadableComponent(
        loadableData = bannerUi,
        loading = {
            Shimmer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
        },
        failureContent = {
            Shimmer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
        },
        loaded = {
            AsyncImage(
                modifier = modifier.height(140.dp),
                model = it.image,
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                placeholder = BrushPainter(
                    Brush.linearGradient(
                        listOf(
                            Color(color = 0xFFFFFFFF),
                            Color(color = 0xFFDDDDDD),
                        ),
                    ),
                ),
            )
        },
        initial = {
            Shimmer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
        },
    )
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    bannerUi: BannerUi,
) {
    AsyncImage(
        modifier = modifier.height(140.dp),
        model = bannerUi.image,
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        onError = {
            println(it.result.throwable)
        },
        placeholder = BrushPainter(
            Brush.linearGradient(
                colors = listOf(
                    Color(color = 0xFFFFFFFF),
                    Color(color = 0xFFDDDDDD),
                ),
            ),
        ),
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
@MediumPhonePreviews
private fun BannerPreview(
    @PreviewParameter(BannerPreviewParameter::class)
    parameter: LoadableData<BannerUi>,
) {
    TarAvazPreview {
        Banner(
            modifier = Modifier.fillMaxWidth(),
            bannerUi = parameter,
        )
    }
}
