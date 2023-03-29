package garousi.dev.taravaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import dagger.hilt.android.AndroidEntryPoint
import garousi.dev.design_system.theme.TarAvazTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           CompositionLocalProvider(
               LocalLayoutDirection provides LayoutDirection.Rtl
           ) {
               TarAvazTheme(
                   androidTheme = true
               ) {
                   TarAvazApp(
                       windowSizeClass = calculateWindowSizeClass(activity = this)
                   )
               }
           }
        }
    }
}