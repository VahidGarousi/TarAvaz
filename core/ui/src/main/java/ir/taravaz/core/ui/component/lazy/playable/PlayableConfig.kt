package ir.taravaz.core.ui.component.lazy.playable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import coil3.compose.AsyncImage
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.component.lazy.playable.preview.PlayablePreviewParameterProvider
import ir.taravaz.core.ui.component.model.TrackUi

private object PlayableConfig {
    const val IMAGE_WEIGHT_RATIO = 3f / 4f
}

@Composable
fun Playable(
    modifier: Modifier = Modifier,
    playable: TrackUi,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(PlayableConfig.IMAGE_WEIGHT_RATIO)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            model = playable.imageUrl,
            contentDescription = null,
        )
        Spacer(Modifier.height(TarAvazTheme.spacing.space2))
        Text(
            text = playable.name,
            style = TarAvazTheme.typography.quickActionTitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(
            text = playable.artistName,
            style = TarAvazTheme.typography.quickActionSubtitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun PlayablePreview(
    @PreviewParameter(PlayablePreviewParameterProvider::class)
    playable: TrackUi,
) {
    TarAvazPreview {
        Playable(
            modifier = Modifier.size(TarAvazTheme.spacing.space96),
            playable = playable,
        )
    }
}
