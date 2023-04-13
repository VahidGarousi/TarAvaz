package garousi.dev.taravaz.feature.track

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import garousi.dev.taravaz.core.design_system.component.TarAvazBackground
import garousi.dev.taravaz.core.design_system.preview.TarAvazPreview
import garousi.dev.taravaz.core.design_system.preview.ThemePreviews

@Composable
fun TrackScreen(
    viewModel: TrackViewModel = hiltViewModel(),
    navigateUp: () -> Unit
) {
    val trackUiState by viewModel.trackUiState.collectAsStateWithLifecycle()
    TarAvazBackground {
        TrackScreenContent(
            state = trackUiState,
            navigateUp = navigateUp
        )
    }
}

@Composable
private fun TrackScreenContent(
    state: TrackUiState,
    navigateUp: () -> Unit
) {
    Column {
        TrackToolbar(modifier = Modifier.fillMaxWidth(), navigateUp = navigateUp)
        if (state is TrackUiState.Loading) {
            TrackLoading()
        } else if (state is TrackUiState.Track) {
            TrackTabRow(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun TrackLoading() {
    Box(Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp),
            strokeWidth = 2.dp
        )
    }
}

@Composable
@ThemePreviews
private fun TrackScreenPreview(
    @PreviewParameter(TrackPreviewParameter::class)
    trackUiState: TrackUiState
) {
    TarAvazPreview {
        TrackScreenContent(state = trackUiState, navigateUp = {})
    }
}