package ir.taravaz.explore.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.preview.MediumPhonePreviews

@Composable
fun ExploreRoot(
    modifier: Modifier = Modifier,
    viewModel: ExploreViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ExploreScreen(
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun ExploreScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_explore_presentation_title),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun Preview() {
    TarAvazTheme {
        ExploreScreen()
    }
}
