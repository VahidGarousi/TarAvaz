package ir.taravaz.core.ui.component.lazy.playable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme

@Composable
fun LazyPlayableList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
    ) {
        items(
            count = 3,
        ) {
            Playable(
                modifier = Modifier.size(TarAvazTheme.spacing.space96),
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun LazyPlayableListPreview() {
    TarAvazPreview {
        LazyPlayableList(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
