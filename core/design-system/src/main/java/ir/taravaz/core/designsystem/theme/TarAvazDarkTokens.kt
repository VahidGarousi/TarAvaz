@file:Suppress("MagicNumber")

package ir.taravaz.core.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal object TarAvazDarkTokens {
    val ActionBarTitleColor: Color = Color(0xFFFFFFFF)
    val ActionBarIconColor: Color = Color(0xFF9E9FB4)
    val CategoryTitleColor: Color = Color(0xFFFFFFFF)
    val ActionBarTextButtonColor: Color = Color(0xFF00F0FF)
    val PlayableTitleColor: Color = Color(0xFFFFFFFF)
    val PlayableSubtitleColor: Color = Color(0xFFFFFFFF)
    val NavigationIconColor: Color = Color(0xFF9E9FB4)
    val BackgroundColor: Color = Color(0xFF00022E)
    val ActionBarGradient: Brush = Brush.linearGradient(
        colors = listOf(Color(0XFF2B2F80), Color(0x0000022E)),
    )
    val SkeletonColor: Color = Color(0xFF1E2537)
    val NavigationContentColor: Color = Color(0xFF9E9FB4)
    val NavigationSelectedItemColor: Color = Color(0xFFFFFFFF)
    val NavigationIndicatorColor: Color = Color(0xFF9E9FB4)
}
