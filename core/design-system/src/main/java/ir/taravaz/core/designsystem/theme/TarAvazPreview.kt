package ir.taravaz.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import ir.taravaz.core.designsystem.component.TarAvazBackground

@OptIn(ExperimentalCoilApi::class)
@Composable
fun TarAvazPreview(content: @Composable () -> Unit) {
    TarAvazTheme {
        val previewHandler = AsyncImagePreviewHandler {
            ColorImage(Color.Red.toArgb())
        }
        TarAvazBackground {
            CompositionLocalProvider(
                LocalAsyncImagePreviewHandler provides previewHandler,
                LocalLayoutDirection provides LayoutDirection.Rtl,
                content = content,
            )
        }
    }
}
