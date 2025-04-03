package ir.taravaz.core.track.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import coil3.compose.AsyncImage
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.designsystem.theme.typography.bold
import ir.taravaz.core.designsystem.theme.typography.normal
import ir.taravaz.core.track.presentation.component.preview.TrackPreviewParameterProvider
import ir.taravaz.core.track.presentation.model.TrackUi

@Composable
fun TrackCard(
    modifier: Modifier = Modifier,
    track: TrackUi,
    onClick: (TrackUi) -> Unit,
) {
    Column(
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = {
                    onClick(track)
                },
            ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(TarAvazTheme.shapes.rectangle16Radius),
        ) {
            AsyncImage(
                modifier = Modifier.matchParentSize(),
                model = track.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }
        Spacer(Modifier.height(TarAvazTheme.spacing.space4))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = track.name,
                style = TarAvazTheme.typography.persian.label1.bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFFFFFFFF),
            )
            Text(
                text = track.artistName,
                style = TarAvazTheme.typography.persian.label1.normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF999AAB),
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun TrackCardPreview(
    @PreviewParameter(TrackPreviewParameterProvider::class)
    track: TrackUi,
) {
    TarAvazPreview {
        TrackCard(
            modifier = Modifier.width(TarAvazTheme.spacing.space116),
            track = track,
            onClick = {
            },
        )
    }
}

private object TrackCardConfig {
    const val IMAGE_WEIGHT_RATIO = 1f
}
