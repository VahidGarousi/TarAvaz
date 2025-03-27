package ir.taravaz.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class TarAvazSpacing(
    val space2: Dp = 2.0.dp,
    val space4: Dp = 4.0.dp,
    val space8: Dp = 8.0.dp,
    val space12: Dp = 12.0.dp,
    val space16: Dp = 16.0.dp,
    val space20: Dp = 20.0.dp,
    val space24: Dp = 24.0.dp,
    val space28: Dp = 28.0.dp,
    val space32: Dp = 32.0.dp,
    val space36: Dp = 36.0.dp,
    val space40: Dp = 40.0.dp,
    val space44: Dp = 44.0.dp,
    val space48: Dp = 48.0.dp,
    val space52: Dp = 52.0.dp,
    val space56: Dp = 56.0.dp,
    val space60: Dp = 60.0.dp,
    val space64: Dp = 64.0.dp,
    val space68: Dp = 68.0.dp,
    val space72: Dp = 72.0.dp,
    val space76: Dp = 76.0.dp,
    val space80: Dp = 80.0.dp,
    val space84: Dp = 84.0.dp,
    val space88: Dp = 88.0.dp,
    val space92: Dp = 92.0.dp,
    val space96: Dp = 96.0.dp,
    val space100: Dp = 100.0.dp,
    val space104: Dp = 104.0.dp,
    val space108: Dp = 108.0.dp,
)

val LocalTarAvazSpacing = staticCompositionLocalOf { TarAvazSpacing() }
