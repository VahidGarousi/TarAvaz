package ir.taravaz.playlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview

@Composable
fun PlaylistRoot(
    modifier: Modifier = Modifier,
    viewModel: PlaylistViewModel = viewModel(),
) {
    PlaylistScreen(
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun PlaylistScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_playlist_presentation_title),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun PlaylistPreview() {
    TarAvazPreview {
        PlaylistScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
