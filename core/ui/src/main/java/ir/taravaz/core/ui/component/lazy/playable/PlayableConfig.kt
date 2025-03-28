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
import coil3.compose.AsyncImage
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme

private object PlayableConfig {
    const val IMAGE_WEIGHT_RATIO = 3f / 4f
}

@Composable
fun Playable(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(PlayableConfig.IMAGE_WEIGHT_RATIO)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            model = "https://google.com",
            contentDescription = null,
        )
        Spacer(Modifier.height(TarAvazTheme.spacing.space2))
        Text(
            text = "شهرزاد",
            style = TarAvazTheme.typography.quickActionTitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(
            text = "حجت اشرف زاده",
            style = TarAvazTheme.typography.quickActionSubtitle,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun PlayablePreview() {
    TarAvazPreview {
        Playable(
            modifier = Modifier.size(TarAvazTheme.spacing.space96),
        )
    }
}
