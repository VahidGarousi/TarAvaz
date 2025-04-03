package ir.taravaz.core.ui.component.lazy.playlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.designsystem.theme.typography.bold
import ir.taravaz.core.designsystem.theme.typography.medium
import ir.taravaz.core.ui.component.shimmer.Shimmer

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
            style = TarAvazTheme.typography.persian.body1.bold,
            modifier = Modifier.align(Alignment.CenterStart),
            color = Color(0xFFFFFFFF),
        )
        TextButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            Text(
                text = "همه",
                style = TarAvazTheme.typography.persian.body2.medium,
                color = Color(0XFF00F0FF),
            )
        }
    }
}

@Composable
fun SectionHeaderLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Shimmer(
            modifier = Modifier
                .height(TarAvazTheme.spacing.space8)
                .width(TarAvazTheme.spacing.space48)
                .align(Alignment.CenterStart),
        )
        Shimmer(
            modifier = Modifier
                .height(TarAvazTheme.spacing.space8)
                .width(TarAvazTheme.spacing.space48)
                .align(Alignment.CenterEnd),
        )
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
