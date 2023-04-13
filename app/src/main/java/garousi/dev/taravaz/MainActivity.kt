package garousi.dev.taravaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import dagger.hilt.android.AndroidEntryPoint
import garousi.dev.taravaz.core.design_system.theme.TarAvazTheme
import garousi.dev.taravaz.ui.TarAvazApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           CompositionLocalProvider(
               LocalLayoutDirection provides LayoutDirection.Rtl
           ) {
               TarAvazTheme(
                   androidTheme = true
               ) {
                   TarAvazApp()
               }
           }
        }
    }
}