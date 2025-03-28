package ir.taravaz.core.ui.component.lazy.playable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.ui.component.lazy.playlist.SectionHeader

@Composable
fun HorizontalPlayableList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        SectionHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "\uD83D\uDE80 داغِ داغ، همین الان!",
        )
        LazyPlayableList(modifier)
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalPlayableListPreview() {
    TarAvazPreview {
        HorizontalPlayableList(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
