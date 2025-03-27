package ir.taravaz.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

internal object TarAvazTypographyTokens {
    val QuickActionTitle = DefaultTextStyle.copy(
        fontSize = 8.sp,
        fontWeight = FontWeight.Bold,
    )
    val QuickActionSubtitle = DefaultTextStyle.copy(
        fontSize = 6.sp,
        fontWeight = FontWeight.Normal,
    )
}

@Immutable
class TarAvazTypography(
    val quickActionTitle: TextStyle = TarAvazTypographyTokens.QuickActionTitle,
    val quickActionSubtitle: TextStyle = TarAvazTypographyTokens.QuickActionSubtitle,
) {
    fun copy(
        quickActionTitle: TextStyle = this.quickActionTitle,
        quickActionSubtitle: TextStyle = this.quickActionSubtitle,
    ) = TarAvazTypography(
        quickActionTitle = quickActionTitle,
        quickActionSubtitle = quickActionSubtitle,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TarAvazTypography) return false
        if (quickActionTitle != other.quickActionTitle) return false
        if (quickActionSubtitle != other.quickActionSubtitle) return false
        return true
    }

    override fun hashCode(): Int {
        var result = quickActionTitle.hashCode()
        result = 31 * result + quickActionSubtitle.hashCode()
        return result
    }

    override fun toString(): String =
        "TarAvazTypography(" +
            "quickActionTitle=$quickActionTitle, " +
            "quickActionSubtitle=$quickActionSubtitle" +
            ")"
}

internal val DefaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None,
)

internal val DefaultTextStyle = TextStyle.Default.copy(
    platformStyle = defaultPlatformTextStyle(),
    lineHeightStyle = DefaultLineHeightStyle,
    fontFamily = iranSans,
)

private const val DEFAULT_INCLUDE_FONT_PADDING = false

private fun defaultPlatformTextStyle(): PlatformTextStyle? = PlatformTextStyle(includeFontPadding = DEFAULT_INCLUDE_FONT_PADDING)

internal val LocalTarAvazTypography = staticCompositionLocalOf { TarAvazTypography() }
