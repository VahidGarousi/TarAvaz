package ir.taravaz.core.designsystem.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

internal object TarAvazTypographyTokens {
    internal object Persian {
        val H1 = DefaultPersianTextStyle.copy(
            fontSize = 56.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 64.sp,
        )
        val H2 = DefaultPersianTextStyle.copy(
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 56.sp,
        )
        val H3 = DefaultPersianTextStyle.copy(
            fontSize = 40.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 56.sp,
        )
        val H4 = DefaultPersianTextStyle.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 48.sp,
        )
        val H5 = DefaultPersianTextStyle.copy(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 36.sp,
        )
        val H6 = DefaultPersianTextStyle.copy(
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 48.sp,
        )
        val Subtitle1 = DefaultPersianTextStyle.copy(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 32.sp,
        )
        val Subtitle2 = DefaultPersianTextStyle.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 32.sp,
        )
        val Body1 = DefaultPersianTextStyle.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 28.sp,
        )
        val Body2 = DefaultPersianTextStyle.copy(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 24.sp,
        )
        val Label1 = DefaultPersianTextStyle.copy(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 20.sp,
        )
        val Label2 = DefaultPersianTextStyle.copy(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 20.sp,
        )
        val Tag1 = DefaultPersianTextStyle.copy(
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 18.sp,
        )
    }

    internal object English {
        val H1 = DefaultEnglishTextStyle.copy(
            fontSize = 56.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 64.sp,
        )
        val H2 = DefaultEnglishTextStyle.copy(
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 56.sp,
        )
        val H3 = DefaultEnglishTextStyle.copy(
            fontSize = 40.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 48.sp,
        )
        val H4 = DefaultEnglishTextStyle.copy(
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 40.sp,
        )
        val H5 = DefaultEnglishTextStyle.copy(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 32.sp,
        )
        val Subtitle1 = DefaultEnglishTextStyle.copy(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 28.sp,
        )
        val Subtitle2 = DefaultEnglishTextStyle.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 26.sp,
        )
        val Body1 = DefaultEnglishTextStyle.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 24.sp,
        )
        val Body2 = DefaultEnglishTextStyle.copy(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 20.sp,
        )
        val Label1 = DefaultEnglishTextStyle.copy(
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 16.sp,
        )
        val Tag1 = DefaultEnglishTextStyle.copy(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            platformStyle = PlatformTextStyle(includeFontPadding = true),
            lineHeight = 16.sp,
        )
    }
}

internal val DefaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None,
)

internal val DefaultPersianTextStyle = TextStyle.Default.copy(
    platformStyle = PlatformTextStyle(
        includeFontPadding = true,
    ),
    lineHeightStyle = DefaultLineHeightStyle,
    fontFamily = iranSans,
)

internal val DefaultEnglishTextStyle = DefaultPersianTextStyle.copy(
    fontFamily = monstserrat,
)

fun createPersianTypography() =
    TarAvazTypography(
        h1 = TarAvazTypographyTokens.Persian.H1,
        h2 = TarAvazTypographyTokens.Persian.H2,
        h3 = TarAvazTypographyTokens.Persian.H3,
        h4 = TarAvazTypographyTokens.Persian.H4,
        h5 = TarAvazTypographyTokens.Persian.H5,
        h6 = TarAvazTypographyTokens.Persian.H6,
        subtitle1 = TarAvazTypographyTokens.Persian.Subtitle1,
        subtitle2 = TarAvazTypographyTokens.Persian.Subtitle2,
        body1 = TarAvazTypographyTokens.Persian.Body1,
        body2 = TarAvazTypographyTokens.Persian.Body2,
        label1 = TarAvazTypographyTokens.Persian.Label1,
        label2 = TarAvazTypographyTokens.Persian.Label2,
        tag1 = TarAvazTypographyTokens.Persian.Tag1,
    )

fun createEnglishTypography() =
    TarAvazTypography(
        h1 = TarAvazTypographyTokens.English.H1,
        h2 = TarAvazTypographyTokens.English.H2,
        h3 = TarAvazTypographyTokens.English.H3,
        h4 = TarAvazTypographyTokens.English.H4,
        h5 = TarAvazTypographyTokens.English.H5,
        h6 = TarAvazTypographyTokens.English.H5, // fallback, or add `H6` to tokens
        subtitle1 = TarAvazTypographyTokens.English.Subtitle1,
        subtitle2 = TarAvazTypographyTokens.English.Subtitle2,
        body1 = TarAvazTypographyTokens.English.Body1,
        body2 = TarAvazTypographyTokens.English.Body2,
        label1 = TarAvazTypographyTokens.English.Label1,
        label2 = TarAvazTypographyTokens.English.Label1, // fallback, or add `Label2`
        tag1 = TarAvazTypographyTokens.English.Tag1,
    )

fun createPersianTypographyCompact() =
    TarAvazTypography(
        h1 = TextStyle(
            fontSize = 54.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        h2 = TextStyle(
            fontSize = 46.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        h3 = TextStyle(
            fontSize = 38.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        h4 = TextStyle(
            fontSize = 30.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        h5 = TextStyle(
            fontSize = 22.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        h6 = TextStyle(
            fontSize = 18.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        subtitle1 = TextStyle(
            fontSize = 18.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        subtitle2 = TextStyle(
            fontSize = 16.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        body1 = TextStyle(
            fontSize = 14.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        label1 = TextStyle(
            fontSize = 12.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        label2 = TextStyle(
            fontSize = 11.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
        tag1 = TextStyle(
            fontSize = 11.sp,
            fontFamily = iranSans,
            fontWeight = FontWeight.Normal,
        ),
    )

fun createEnglishTypographyCompact() =
    TarAvazTypography(
        h1 = TextStyle(
            fontSize = 54.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        h2 = TextStyle(
            fontSize = 46.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        h3 = TextStyle(
            fontSize = 38.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        h4 = TextStyle(
            fontSize = 30.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        h5 = TextStyle(
            fontSize = 22.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        h6 = TextStyle(
            fontSize = 18.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        subtitle1 = TextStyle(
            fontSize = 18.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        subtitle2 = TextStyle(
            fontSize = 16.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        label1 = TextStyle(
            fontSize = 13.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        label2 = TextStyle(
            fontSize = 12.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
        tag1 = TextStyle(
            fontSize = 12.sp,
            fontFamily = monstserrat,
            fontWeight = FontWeight.Normal,
        ),
    )

val LocalTarAvazTypography = staticCompositionLocalOf {
    TarAvazTypographies()
}

val TextStyle.normal: TextStyle get() = this.copy(fontWeight = FontWeight.Normal)

val TextStyle.medium: TextStyle get() = this.copy(fontWeight = FontWeight.Medium)

val TextStyle.bold: TextStyle get() = this.copy(fontWeight = FontWeight.Bold)
