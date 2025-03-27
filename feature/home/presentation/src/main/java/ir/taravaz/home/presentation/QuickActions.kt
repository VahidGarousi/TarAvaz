package ir.taravaz.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme

private object QuickActionsConfig {
    const val WEIGHT = 1f / 3f
}

@Composable
fun QuickActions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(TarAvazTheme.spacing.space60),
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        QuickAction(
            modifier = Modifier
                .fillMaxHeight()
                .weight(QuickActionsConfig.WEIGHT),
        )
        QuickAction(
            modifier = Modifier
                .fillMaxHeight()
                .weight(QuickActionsConfig.WEIGHT),
        )
        QuickAction(
            modifier = Modifier
                .fillMaxHeight()
                .weight(QuickActionsConfig.WEIGHT),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun QuickActionsPreview() {
    TarAvazPreview {
        QuickActions(
            modifier = Modifier.height(TarAvazTheme.spacing.space60),
        )
    }
}

@Composable
fun QuickAction(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = TarAvazTheme.colors.quickActionBackgroundColor,
            contentColor = TarAvazTheme.colors.quickActionTextColor,
        ),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(TarAvazTheme.spacing.space8)
                .requiredHeight(TarAvazTheme.spacing.space60),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "\uD83C\uDFB5 با یه آهنگ خوب شروع کن",
                style = TarAvazTheme.typography.quickActionTitle,
            )
            Text(
                text = "محبوب\u200Cترین\u200Cها، همین حالا",
                style = TarAvazTheme.typography.quickActionSubtitle,
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun QuickActionPreview() {
    TarAvazPreview {
        QuickAction()
    }
}
