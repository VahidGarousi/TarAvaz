@file:Suppress("CyclomaticComplexMethod", "LongParameterList")

package ir.taravaz.core.designsystem.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
class TarAvazTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val label1: TextStyle,
    val label2: TextStyle,
    val tag1: TextStyle,
) {
    fun copy(
        h1: TextStyle = this.h1,
        h2: TextStyle = this.h2,
        h3: TextStyle = this.h3,
        h4: TextStyle = this.h4,
        h5: TextStyle = this.h5,
        h6: TextStyle = this.h6,
        subtitle1: TextStyle = this.subtitle1,
        subtitle2: TextStyle = this.subtitle2,
        body1: TextStyle = this.body1,
        body2: TextStyle = this.body2,
        label1: TextStyle = this.label1,
        label2: TextStyle = this.label2,
        tag1: TextStyle = this.tag1,
    ) = TarAvazTypography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        h4 = h4,
        h5 = h5,
        h6 = h6,
        subtitle1 = subtitle1,
        subtitle2 = subtitle2,
        body1 = body1,
        body2 = body2,
        label1 = label1,
        label2 = label2,
        tag1 = tag1,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TarAvazTypography) return false
        return h1 == other.h1 &&
            h2 == other.h2 &&
            h3 == other.h3 &&
            h4 == other.h4 &&
            h5 == other.h5 &&
            h6 == other.h6 &&
            subtitle1 == other.subtitle1 &&
            subtitle2 == other.subtitle2 &&
            body1 == other.body1 &&
            body2 == other.body2 &&
            label1 == other.label1 &&
            label2 == other.label2 &&
            tag1 == other.tag1
    }

    override fun hashCode(): Int {
        var result = h1.hashCode()
        result = 31 * result + h2.hashCode()
        result = 31 * result + h3.hashCode()
        result = 31 * result + h4.hashCode()
        result = 31 * result + h5.hashCode()
        result = 31 * result + h6.hashCode()
        result = 31 * result + subtitle1.hashCode()
        result = 31 * result + subtitle2.hashCode()
        result = 31 * result + body1.hashCode()
        result = 31 * result + body2.hashCode()
        result = 31 * result + label1.hashCode()
        result = 31 * result + label2.hashCode()
        result = 31 * result + tag1.hashCode()
        return result
    }

    override fun toString(): String =
        "TarAvazTypography(h1=$h1, h2=$h2, h3=$h3, h4=$h4, h5=$h5, h6=$h6, " +
            "subtitle1=$subtitle1, subtitle2=$subtitle2, body1=$body1, body2=$body2, " +
            "label1=$label1, label2=$label2, tag1=$tag1)"
}
