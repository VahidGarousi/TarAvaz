package ir.taravaz.home.presentation

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
fun HomeRoot(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    HomeRoot(
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun HomeRoot(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_home_presentation_title),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HomePreview() {
    TarAvazPreview {
        HomeRoot(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
