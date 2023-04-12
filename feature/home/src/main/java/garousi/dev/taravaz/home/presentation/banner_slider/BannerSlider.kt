package garousi.dev.taravaz.home.presentation.banner_slider

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import garousi.dev.design_system.component.TarAvazBackground
import garousi.dev.design_system.component.TarAvazGradientBackground
import garousi.dev.design_system.theme.TarAvazTheme
import garousi.dev.taravaz.home.domain.model.Banner

@Composable
fun BannerSlider(
    state: BannerSliderUiState,
    onClick: (Banner) -> Unit
) {
    BoxWithConstraints(
        Modifier
            .height(140.dp)
            .fillMaxWidth()
    ) {
        when (state) {
            BannerSliderUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(24.dp),
                    strokeWidth = 2.dp
                )
            }
            is BannerSliderUiState.Success -> {
                CarouselSlider(
                    banners = state.banners,
                    onClick = onClick,
                    modifier = Modifier.fillMaxSize()
                )
            }
            is BannerSliderUiState.Failure.Unknown -> {
                Text(
                    text = state.message,
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }

}


@Composable
@Preview
fun BannerSliderPreview(
    @PreviewParameter(BannerSliderUiStateProvider::class)
    state: BannerSliderUiState
) {
    TarAvazTheme {
        TarAvazBackground(modifier = Modifier.height(200.dp)) {
            TarAvazGradientBackground {
                BannerSlider(state = state, onClick = {})
            }
        }
    }
}