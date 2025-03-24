package ir.taravaz.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

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

@Composable
fun TarAvazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
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
    val taravazColors = if (darkTheme) tarAvazDarkColors() else tarAvazLightColors()
    TarAvazTheme(
        materialColorScheme = materialColorScheme,
        taravazColors = taravazColors,
        content = content,
    )
}

@Composable
private fun TarAvazTheme(
    materialColorScheme: ColorScheme = MaterialTheme.colorScheme,
    taravazColors: TaravazColors = TarAvazTheme.colors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalTarAvazColors provides taravazColors,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = content,
        )
    }
}

object TarAvazTheme {
    val colors: TaravazColors
        @Composable @ReadOnlyComposable
        get() = LocalTarAvazColors.current
}
