package garousi.dev.taravaz.core.design_system.theme

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.ui.graphics.vector.ImageVector
import garousi.dev.taravaz.core.design_system.R

object TarAvazIcons {
    val Category = R.drawable.ic_category
    val ArrowBack = Icons.Rounded.ArrowForward
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
