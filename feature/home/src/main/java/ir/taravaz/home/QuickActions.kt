package ir.taravaz.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
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
import ir.taravaz.core.designsystem.theme.typography.normal

private object QuickActionsConfig {
    const val WEIGHT = 1f
}

@Composable
fun QuickActions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
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
            modifier = Modifier.height(TarAvazTheme.spacing.space108),
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
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .padding(TarAvazTheme.spacing.space8),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "با یه آهنگ خوب شروع کن",
                style = TarAvazTheme.typography.persian.body2.bold,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(TarAvazTheme.spacing.space4))
            Text(
                text = "محبوب\u200Cترین\u200Cها، همین حالا",
                style = TarAvazTheme.typography.persian.tag1.normal,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun QuickActionPreview() {
    TarAvazPreview {
        QuickAction(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(QuickActionsConfig.WEIGHT),
        )
    }
}
