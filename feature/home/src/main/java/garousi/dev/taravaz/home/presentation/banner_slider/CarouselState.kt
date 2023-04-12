package garousi.dev.taravaz.home.presentation.banner_slider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Stable
class CarouselState {

}


@Composable
fun rememberCarouselState(): CarouselState {
    return remember() {
        CarouselState()
    }
}