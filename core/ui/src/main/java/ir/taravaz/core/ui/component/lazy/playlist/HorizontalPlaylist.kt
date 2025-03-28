package ir.taravaz.core.ui.component.lazy.playlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview

@Composable
fun HorizontalPlaylist(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        SectionHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "\uD83D\uDD25 برترین پلی\u200Cلیست\u200Cها",
        )
        Playlists(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalPlaylistPreview() {
    TarAvazPreview {
        HorizontalPlaylist()
    }
}
