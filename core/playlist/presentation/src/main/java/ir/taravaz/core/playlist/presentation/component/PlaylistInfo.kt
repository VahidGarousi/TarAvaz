package ir.taravaz.core.playlist.presentation.component

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
import ir.taravaz.core.designsystem.theme.typography.bold
import ir.taravaz.core.playlist.presentation.model.PlaylistInfoUi

@Composable
fun PlaylistInfo(
    modifier: Modifier = Modifier,
    information: PlaylistInfoUi,
) {
    ElevatedCard(
        modifier = modifier.size(TarAvazTheme.spacing.space96),
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = information.title,
            style = TarAvazTheme.typography.persian.tag1.bold,
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
        PlaylistInfo(
            information = PlaylistInfoUi(
                id = "",
                title = "\uD83D\uDE80 برای روزای پرانرژی",
            ),
        )
    }
}
