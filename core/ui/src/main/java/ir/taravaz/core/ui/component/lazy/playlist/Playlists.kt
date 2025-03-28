package ir.taravaz.core.ui.component.lazy.playlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.component.card.playlist.Playlist

@Composable
fun Playlists(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
    ) {
        items(
            count = 3,
        ) {
            Playlist()
        }
    }
}

@MediumPhonePreviews
@Composable
private fun PlaylistsPreview() {
    TarAvazPreview {
        Playlists()
    }
}
