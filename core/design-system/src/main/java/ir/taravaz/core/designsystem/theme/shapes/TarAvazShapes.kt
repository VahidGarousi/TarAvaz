@file:Suppress("CyclomaticComplexMethod")

package ir.taravaz.core.designsystem.theme.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
class TarAvazShapes(
    val rectangle: Shape = RectangleShape,
    val rectangle2Radius: Shape = RoundedCornerShape(2.dp),
    val rectangle4Radius: Shape = RoundedCornerShape(4.dp),
    val rectangle6Radius: Shape = RoundedCornerShape(6.dp),
    val rectangle8Radius: Shape = RoundedCornerShape(8.dp),
    val rectangle10Radius: Shape = RoundedCornerShape(10.dp),
    val rectangle12Radius: Shape = RoundedCornerShape(12.dp),
    val rectangle14Radius: Shape = RoundedCornerShape(14.dp),
    val rectangle16Radius: Shape = RoundedCornerShape(16.dp),
    val rectangle20Radius: Shape = RoundedCornerShape(20.dp),
    val rectangle24Radius: Shape = RoundedCornerShape(24.dp),
    val rectangle32Radius: Shape = RoundedCornerShape(32.dp),
    val rectangle40Radius: Shape = RoundedCornerShape(40.dp),
    val rectangle48Radius: Shape = RoundedCornerShape(48.dp),
    val rectangle50Radius: Shape = RoundedCornerShape(50.dp),
    val rectangle56Radius: Shape = RoundedCornerShape(56.dp),
    val rectangle64Radius: Shape = RoundedCornerShape(64.dp),
    val rectangle72Radius: Shape = RoundedCornerShape(72.dp),
    val rectangleBottomRadius: Shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomEnd = 16.dp,
        bottomStart = 16.dp,
    ),
    val rectangleTopRadius8: Shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp),
    val rectangleTopRadius12: Shape = RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp),
    val rectangleTopRadius24: Shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
    val rectangleTop24Bottom4Radius: Shape = RoundedCornerShape(
        topEnd = 24.dp,
        topStart = 24.dp,
        bottomEnd = 4.dp,
        bottomStart = 4.dp,
    ),
    val rectangle4Top16BottomRadius: Shape = RoundedCornerShape(
        topEnd = 4.dp,
        topStart = 4.dp,
        bottomEnd = 16.dp,
        bottomStart = 16.dp,
    ),
    val rectangle4Top10BottomRadius: Shape = RoundedCornerShape(
        topEnd = 4.dp,
        topStart = 4.dp,
        bottomEnd = 10.dp,
        bottomStart = 10.dp,
    ),
    val rectangle16Top4BottomRadius: Shape = RoundedCornerShape(
        topEnd = 16.dp,
        topStart = 16.dp,
        bottomEnd = 4.dp,
        bottomStart = 4.dp,
    ),
    val rectangle16Start4EndRadius: Shape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 4.dp,
        bottomStart = 16.dp,
        bottomEnd = 4.dp,
    ),
    val rectangle4Start16EndRadius: Shape = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 16.dp,
        bottomStart = 4.dp,
        bottomEnd = 16.dp,
    ),
    val rectangle16BottomRadius: Shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp,
    ),
    val rectangle24BottomRadius: Shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 24.dp,
        bottomEnd = 24.dp,
    ),
    val rectangle4TopRadius: Shape = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 4.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp,
    ),
    val rectangle16TopRadius: Shape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp,
    ),
    val rectangle14BottomRadius: Shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 14.dp,
        bottomEnd = 14.dp,
    ),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TarAvazShapes) return false
        if (rectangle != other.rectangle) return false
        if (rectangle2Radius != other.rectangle2Radius) return false
        if (rectangle4Radius != other.rectangle4Radius) return false
        if (rectangle6Radius != other.rectangle6Radius) return false
        if (rectangle8Radius != other.rectangle8Radius) return false
        if (rectangle10Radius != other.rectangle10Radius) return false
        if (rectangle12Radius != other.rectangle12Radius) return false
        if (rectangle14Radius != other.rectangle14Radius) return false
        if (rectangle16Radius != other.rectangle16Radius) return false
        if (rectangle20Radius != other.rectangle20Radius) return false
        if (rectangle24Radius != other.rectangle24Radius) return false
        if (rectangle32Radius != other.rectangle32Radius) return false
        if (rectangle40Radius != other.rectangle40Radius) return false
        if (rectangle48Radius != other.rectangle48Radius) return false
        if (rectangle50Radius != other.rectangle50Radius) return false
        if (rectangle56Radius != other.rectangle56Radius) return false
        if (rectangle64Radius != other.rectangle64Radius) return false
        if (rectangle72Radius != other.rectangle72Radius) return false
        if (rectangleBottomRadius != other.rectangleBottomRadius) return false
        if (rectangleTopRadius8 != other.rectangleTopRadius8) return false
        if (rectangleTopRadius12 != other.rectangleTopRadius12) return false
        if (rectangleTopRadius24 != other.rectangleTopRadius24) return false
        if (rectangleTop24Bottom4Radius != other.rectangleTop24Bottom4Radius) return false
        if (rectangle4Top16BottomRadius != other.rectangle4Top16BottomRadius) return false
        if (rectangle4Top10BottomRadius != other.rectangle4Top10BottomRadius) return false
        if (rectangle16Top4BottomRadius != other.rectangle16Top4BottomRadius) return false
        if (rectangle16Start4EndRadius != other.rectangle16Start4EndRadius) return false
        if (rectangle4Start16EndRadius != other.rectangle4Start16EndRadius) return false
        if (rectangle16BottomRadius != other.rectangle16BottomRadius) return false
        if (rectangle24BottomRadius != other.rectangle24BottomRadius) return false
        if (rectangle4TopRadius != other.rectangle4TopRadius) return false
        if (rectangle16TopRadius != other.rectangle16TopRadius) return false
        return rectangle14BottomRadius == other.rectangle14BottomRadius
    }

    override fun hashCode(): Int {
        var result = rectangle.hashCode()
        result = 31 * result + rectangle2Radius.hashCode()
        result = 31 * result + rectangle4Radius.hashCode()
        result = 31 * result + rectangle6Radius.hashCode()
        result = 31 * result + rectangle8Radius.hashCode()
        result = 31 * result + rectangle10Radius.hashCode()
        result = 31 * result + rectangle12Radius.hashCode()
        result = 31 * result + rectangle14Radius.hashCode()
        result = 31 * result + rectangle16Radius.hashCode()
        result = 31 * result + rectangle20Radius.hashCode()
        result = 31 * result + rectangle24Radius.hashCode()
        result = 31 * result + rectangle32Radius.hashCode()
        result = 31 * result + rectangle40Radius.hashCode()
        result = 31 * result + rectangle48Radius.hashCode()
        result = 31 * result + rectangle50Radius.hashCode()
        result = 31 * result + rectangle56Radius.hashCode()
        result = 31 * result + rectangle64Radius.hashCode()
        result = 31 * result + rectangle72Radius.hashCode()
        result = 31 * result + rectangleBottomRadius.hashCode()
        result = 31 * result + rectangleTopRadius8.hashCode()
        result = 31 * result + rectangleTopRadius12.hashCode()
        result = 31 * result + rectangleTopRadius24.hashCode()
        result = 31 * result + rectangleTop24Bottom4Radius.hashCode()
        result = 31 * result + rectangle4Top16BottomRadius.hashCode()
        result = 31 * result + rectangle4Top10BottomRadius.hashCode()
        result = 31 * result + rectangle16Top4BottomRadius.hashCode()
        result = 31 * result + rectangle16Start4EndRadius.hashCode()
        result = 31 * result + rectangle4Start16EndRadius.hashCode()
        result = 31 * result + rectangle16BottomRadius.hashCode()
        result = 31 * result + rectangle24BottomRadius.hashCode()
        result = 31 * result + rectangle4TopRadius.hashCode()
        result = 31 * result + rectangle16TopRadius.hashCode()
        result = 31 * result + rectangle14BottomRadius.hashCode()
        return result
    }

    override fun toString(): String =
        "TarAvazShapes(" +
            "rectangle=$rectangle, " +
            "rectangle2Radius=$rectangle2Radius, " +
            "rectangle4Radius=$rectangle4Radius, " +
            "rectangle6Radius=$rectangle6Radius, " +
            "rectangle8Radius=$rectangle8Radius, " +
            "rectangle10Radius=$rectangle10Radius, " +
            "rectangle12Radius=$rectangle12Radius, " +
            "rectangle14Radius=$rectangle14Radius, " +
            "rectangle16Radius=$rectangle16Radius, " +
            "rectangle20Radius=$rectangle20Radius, " +
            "rectangle24Radius=$rectangle24Radius, " +
            "rectangle32Radius=$rectangle32Radius, " +
            "rectangle40Radius=$rectangle40Radius, " +
            "rectangle48Radius=$rectangle48Radius, " +
            "rectangle50Radius=$rectangle50Radius, " +
            "rectangle56Radius=$rectangle56Radius, " +
            "rectangle64Radius=$rectangle64Radius, " +
            "rectangle72Radius=$rectangle72Radius, " +
            "rectangleBottomRadius=$rectangleBottomRadius, " +
            "rectangleTopRadius8=$rectangleTopRadius8, " +
            "rectangleTopRadius12=$rectangleTopRadius12, " +
            "rectangleTopRadius24=$rectangleTopRadius24, " +
            "rectangleTop24Bottom4Radius=$rectangleTop24Bottom4Radius, " +
            "rectangle4Top16BottomRadius=$rectangle4Top16BottomRadius, " +
            "rectangle4Top10BottomRadius=$rectangle4Top10BottomRadius, " +
            "rectangle16Top4BottomRadius=$rectangle16Top4BottomRadius, " +
            "rectangle16Start4EndRadius=$rectangle16Start4EndRadius, " +
            "rectangle4Start16EndRadius=$rectangle4Start16EndRadius, " +
            "rectangle16BottomRadius=$rectangle16BottomRadius, " +
            "rectangle24BottomRadius=$rectangle24BottomRadius, " +
            "rectangle4TopRadius=$rectangle4TopRadius, " +
            "rectangle16TopRadius=$rectangle16TopRadius, " +
            "rectangle14BottomRadius=$rectangle14BottomRadius)"
}

val LocalTarAvazShapes = staticCompositionLocalOf { TarAvazShapes() }
