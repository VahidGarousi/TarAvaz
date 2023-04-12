package garousi.dev.taravaz.core.design_system.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import garousi.dev.taravaz.core.design_system.component.TarAvazBackground
import garousi.dev.taravaz.core.design_system.component.TarAvazGradientBackground
import garousi.dev.taravaz.core.design_system.theme.TarAvazTheme

@Composable
fun TarAvazPreview(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        TarAvazTheme {
            TarAvazBackground {
                TarAvazGradientBackground {
                    content()
                }
            }
        }
    }
}