package ir.taravaz.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.preview.MediumPhonePreviews

@Composable
fun ProfileRoot(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel(),
) {
    ProfileScreen(
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.feature_profile_presentation_title),
        )
    }
}

@MediumPhonePreviews
@Composable
private fun Preview() {
    TarAvazTheme {
        ProfileScreen()
    }
}
