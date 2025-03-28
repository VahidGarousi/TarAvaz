package ir.taravaz.core.ui.component.lazy.playlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = TarAvazTheme.typography.quickActionTitle,
            modifier = Modifier.align(Alignment.CenterStart),
        )
        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            Text(
                text = "همه",
                style = TarAvazTheme.typography.quickActionTitle,
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun SectionHeaderPreview() {
    TarAvazPreview {
        SectionHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "\uD83D\uDD25 برترین پلی\u200Cلیست\u200Cها",
        )
    }
}
