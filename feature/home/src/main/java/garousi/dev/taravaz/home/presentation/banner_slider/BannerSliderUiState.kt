package garousi.dev.taravaz.home.presentation.banner_slider

import garousi.dev.taravaz.home.domain.model.Banner

/**
 * When we request banners, it takes some time to get banners
 * @property [Loading] we emit loading state when we request banners
 * @property [Success] We emit banners to showing in BannerSlider composable
 * @property [Failure.Unknown] is suitable when we got error from server
 *
 * @sample [BannerSlider]
 */
sealed class BannerSliderUiState {
    object Loading : BannerSliderUiState()
    data class Success(val banners: List<Banner>) : BannerSliderUiState()
    sealed class Failure : BannerSliderUiState() {
        data class Unknown(val message: String) : BannerSliderUiState()
    }
}