package ir.taravaz.core.ui.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * Parameter provider to supply different UIMode.
 */
class UiModeParameterProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = sequenceOf(
            Configuration.UI_MODE_NIGHT_NO,
            Configuration.UI_MODE_NIGHT_YES,
        )
}
