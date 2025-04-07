@file:Suppress("MagicNumber")

package ir.taravaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.tracing.trace
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.ui.TarAvazApp
import ir.taravaz.ui.rememberTarAvazState
import ir.taravaz.util.isSystemInDarkTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                isSystemInDarkTheme().distinctUntilChanged().collect { darkTheme ->
                    trace("tarAvazEdgeToEdge") {
                        // Turn off the decor fitting system windows, which allows us to handle insets,
                        // including IME animations, and go edge-to-edge.
                        // This is the same parameters as the default enableEdgeToEdge call, but we manually
                        // resolve whether or not to show dark theme using uiState, since it can be different
                        // than the configuration's dark theme value based on the user preference.
                        enableEdgeToEdge(
                            statusBarStyle = SystemBarStyle.auto(
                                lightScrim = android.graphics.Color.TRANSPARENT,
                                darkScrim = android.graphics.Color.TRANSPARENT,
                            ) { darkTheme },
                            navigationBarStyle = SystemBarStyle.auto(
                                lightScrim = lightScrim,
                                darkScrim = darkScrim,
                            ) { darkTheme },
                        )
                    }
                }
            }
        }
        setContent {
            val windowAdaptiveInfo = currentWindowAdaptiveInfo()
            KoinContext {
                TarAvazTheme(
                    windowAdaptiveInfo = windowAdaptiveInfo,
                    darkTheme = true,
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                        TarAvazApp(
                            appState = rememberTarAvazState(),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
                            windowAdaptiveInfo = windowAdaptiveInfo,
                        )
                    }
                }
            }
        }
    }
}

/**
 * The default light scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

/**
 * The default dark scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)
