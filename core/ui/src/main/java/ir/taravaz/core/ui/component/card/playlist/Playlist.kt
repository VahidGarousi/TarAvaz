package ir.taravaz.core.ui.component.card.playlist

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme

@Composable
fun Playlist(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.size(TarAvazTheme.spacing.space96),
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = "\uD83D\uDE80 برای روزای پرانرژی",
            style = TarAvazTheme.typography.quickActionSubtitle,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.weight(1f))
    }
}

@MediumPhonePreviews
@Composable
private fun PlaylistPreview() {
    TarAvazPreview {
        Playlist()
    }
}
