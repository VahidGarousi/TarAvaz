package ir.taravaz.core.ui.component.card.playable.banner

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
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableBannerUi
import ir.taravaz.core.ui.component.shimmer.Shimmer
import ir.taravaz.core.ui.preview.MediumPhonePreviews

@Composable
fun PlayableBanner(
    modifier: Modifier = Modifier,
    playableBannerUi: LoadableData<PlayableBannerUi>,
) {
    LoadableComponent(
        loadableData = playableBannerUi,
        loading = {
            Shimmer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
        },
        error = {
            Shimmer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
        },
        loaded = {
            AsyncImage(
                modifier = modifier.height(140.dp),
                model = it.cover,
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
fun PlayableBanner(
    modifier: Modifier = Modifier,
    playableBannerUi: PlayableBannerUi,
) {
    AsyncImage(
        modifier = modifier.height(140.dp),
        model = playableBannerUi.cover,
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
}

@OptIn(ExperimentalCoilApi::class)
@Composable
@MediumPhonePreviews
private fun PlayableBannerPreview(
    @PreviewParameter(PlayableBannerPreviewParameter::class)
    parameter: LoadableData<PlayableBannerUi>,
) {
    TarAvazPreview {
        PlayableBanner(
            modifier = Modifier.fillMaxWidth(),
            playableBannerUi = parameter,
        )
    }
}
