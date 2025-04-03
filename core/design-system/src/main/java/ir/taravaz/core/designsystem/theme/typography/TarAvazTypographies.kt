package ir.taravaz.core.designsystem.theme.typography

import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.window.core.layout.WindowWidthSizeClass

@Immutable
class TarAvazTypographies(
    val persian: TarAvazTypography = createPersianTypography(),
    val english: TarAvazTypography = createEnglishTypography(),
) {
    fun copy(
        persian: TarAvazTypography = this.persian,
        english: TarAvazTypography = this.english,
    ) = TarAvazTypographies(
        persian = persian,
        english = english,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TarAvazTypographies) return false
        if (persian != other.persian) return false
        if (english != other.english) return false
        return true
    }

    override fun hashCode(): Int {
        var result = persian.hashCode()
        result = 31 * result + english.hashCode()
        return result
    }

    override fun toString(): String =
        "TarAvazTypographySet(" +
            "persian=$persian, " +
            "english=$english" +
            ")"

    companion object {
        fun compact(): TarAvazTypographies =
            TarAvazTypographies(
                persian = createPersianTypographyCompact(),
                english = createEnglishTypographyCompact(),
            )

        fun medium(): TarAvazTypographies =
            TarAvazTypographies(
                persian = createPersianTypography(),
                english = createEnglishTypography(),
            )
    }
}

@Composable
internal fun tarAvazTypographies(windowAdaptiveInfo: WindowAdaptiveInfo): TarAvazTypographies =
    when (windowAdaptiveInfo.windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> TarAvazTypographies.compact()
        WindowWidthSizeClass.MEDIUM -> TarAvazTypographies.medium()
        WindowWidthSizeClass.EXPANDED -> TarAvazTypographies.medium()
        else -> TarAvazTypographies.medium()
    }
