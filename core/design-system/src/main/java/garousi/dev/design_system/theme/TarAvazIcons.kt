package garousi.dev.design_system.theme

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import garousi.dev.taravaz.core.design_system.R

object TarAvazIcons {
    val Category = R.drawable.ic_category
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
