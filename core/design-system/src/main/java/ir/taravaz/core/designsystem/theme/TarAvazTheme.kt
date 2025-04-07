package ir.taravaz.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import ir.taravaz.core.designsystem.theme.colors.LocalTarAvazColors
import ir.taravaz.core.designsystem.theme.colors.Pink40
import ir.taravaz.core.designsystem.theme.colors.Pink80
import ir.taravaz.core.designsystem.theme.colors.Purple40
import ir.taravaz.core.designsystem.theme.colors.Purple80
import ir.taravaz.core.designsystem.theme.colors.PurpleGrey40
import ir.taravaz.core.designsystem.theme.colors.PurpleGrey80
import ir.taravaz.core.designsystem.theme.colors.TarAvazDarkTokens
import ir.taravaz.core.designsystem.theme.colors.TarAvazLightTokens
import ir.taravaz.core.designsystem.theme.colors.TaravazColors
import ir.taravaz.core.designsystem.theme.colors.tarAvazDarkColors
import ir.taravaz.core.designsystem.theme.colors.tarAvazLightColors
import ir.taravaz.core.designsystem.theme.shapes.LocalTarAvazShapes
import ir.taravaz.core.designsystem.theme.shapes.TarAvazShapes
import ir.taravaz.core.designsystem.theme.spacing.LocalTarAvazSpacing
import ir.taravaz.core.designsystem.theme.spacing.TarAvazSpacing
import ir.taravaz.core.designsystem.theme.typography.LocalTarAvazTypography
import ir.taravaz.core.designsystem.theme.typography.TarAvazTypographies
import ir.taravaz.core.designsystem.theme.typography.tarAvazTypographies

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
)

/**
 * Light Android background theme
 */
val LightBackgroundTheme = BackgroundTheme(color = TarAvazLightTokens.BackgroundColor)

/**
 * Dark Android background theme
 */
val DarkBackgroundTheme = BackgroundTheme(color = TarAvazDarkTokens.BackgroundColor)

@Composable
fun TarAvazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val materialColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val backgroundTheme = if (darkTheme) DarkBackgroundTheme else LightBackgroundTheme
    val taravazColors = if (darkTheme) tarAvazDarkColors() else tarAvazLightColors()
    val shimmerInstance = rememberShimmer(ShimmerBounds.Window)

    CompositionLocalProvider(
        LocalTarAvazColors provides taravazColors,
        LocalBackgroundTheme provides backgroundTheme,
        LocalTarAvazTypography provides tarAvazTypographies(windowAdaptiveInfo = windowAdaptiveInfo),
        LocalTarAvazShapes provides TarAvazShapes(),
        LocalLayoutDirection provides LayoutDirection.Rtl,
        LocalShimmer provides shimmerInstance,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography(),
            content = content,
        )
    }
}

object TarAvazTheme {
    val colors: TaravazColors
        @Composable @ReadOnlyComposable
        get() = LocalTarAvazColors.current

    val typography: TarAvazTypographies
        @Composable @ReadOnlyComposable
        get() = LocalTarAvazTypography.current

    val spacing: TarAvazSpacing
        @Composable @ReadOnlyComposable
        get() = LocalTarAvazSpacing.current

    val shapes: TarAvazShapes
        @Composable @ReadOnlyComposable
        get() = LocalTarAvazShapes.current
}

val LocalShimmer = staticCompositionLocalOf<Shimmer> { error("No Local provider provided") }
