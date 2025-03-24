@file:Suppress("LongParameterList")

package ir.taravaz.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Immutable
class TaravazColors(
    val actionBarTitleColor: Color,
    val actionBarIconColor: Color,
    val categoryTitleColor: Color,
    val actionBarTextButtonColor: Color,
    val playableTitleColor: Color,
    val playableSubtitleColor: Color,
    val navigationIconColor: Color,
    val backgroundColor: Color,
    val actionBarGradient: Brush,
) {
    fun copy(
        actionBarTitleColor: Color,
        actionBarIconColor: Color,
        categoryTitleColor: Color,
        actionBarTextButtonColor: Color,
        playableTitleColor: Color,
        playableSubtitleColor: Color,
        navigationIconColor: Color,
        backgroundColor: Color,
    ) = TaravazColors(
        actionBarTitleColor = this.actionBarTitleColor,
        actionBarIconColor = this.actionBarIconColor,
        categoryTitleColor = this.categoryTitleColor,
        actionBarTextButtonColor = this.actionBarTextButtonColor,
        playableTitleColor = this.playableTitleColor,
        playableSubtitleColor = this.playableSubtitleColor,
        navigationIconColor = this.navigationIconColor,
        backgroundColor = this.backgroundColor,
        actionBarGradient = this.actionBarGradient,
    )
}

fun tarAvazLightColors(
    actionBarTitleColor: Color = TarAvazLightTokens.ActionBarTitleColor,
    actionBarIconColor: Color = TarAvazLightTokens.ActionBarIconColor,
    categoryTitleColor: Color = TarAvazLightTokens.CategoryTitleColor,
    actionBarTextButtonColor: Color = TarAvazLightTokens.ActionBarTextButtonColor,
    playableTitleColor: Color = TarAvazLightTokens.PlayableTitleColor,
    playableSubtitleColor: Color = TarAvazLightTokens.PlayableSubtitleColor,
    navigationIconColor: Color = TarAvazLightTokens.NavigationIconColor,
    backgroundColor: Color = TarAvazLightTokens.BackgroundColor,
    actionBarGradient: Brush = TarAvazLightTokens.ActionBarGradient,
): TaravazColors =
    TaravazColors(
        actionBarTitleColor = actionBarTitleColor,
        actionBarIconColor = actionBarIconColor,
        categoryTitleColor = categoryTitleColor,
        actionBarTextButtonColor = actionBarTextButtonColor,
        playableTitleColor = playableTitleColor,
        playableSubtitleColor = playableSubtitleColor,
        navigationIconColor = navigationIconColor,
        backgroundColor = backgroundColor,
        actionBarGradient = actionBarGradient,
    )

fun tarAvazDarkColors(
    actionBarTitleColor: Color = TarAvazDarkTokens.ActionBarTitleColor,
    actionBarIconColor: Color = TarAvazDarkTokens.ActionBarIconColor,
    categoryTitleColor: Color = TarAvazDarkTokens.CategoryTitleColor,
    actionBarTextButtonColor: Color = TarAvazDarkTokens.ActionBarTextButtonColor,
    playableTitleColor: Color = TarAvazDarkTokens.PlayableTitleColor,
    playableSubtitleColor: Color = TarAvazDarkTokens.PlayableSubtitleColor,
    navigationIconColor: Color = TarAvazDarkTokens.NavigationIconColor,
    backgroundColor: Color = TarAvazDarkTokens.BackgroundColor,
    actionBarGradient: Brush = TarAvazDarkTokens.ActionBarGradient,
): TaravazColors =
    TaravazColors(
        actionBarTitleColor = actionBarTitleColor,
        actionBarIconColor = actionBarIconColor,
        categoryTitleColor = categoryTitleColor,
        actionBarTextButtonColor = actionBarTextButtonColor,
        playableTitleColor = playableTitleColor,
        playableSubtitleColor = playableSubtitleColor,
        navigationIconColor = navigationIconColor,
        backgroundColor = backgroundColor,
        actionBarGradient = actionBarGradient,
    )

internal val LocalTarAvazColors = staticCompositionLocalOf { tarAvazDarkColors() }
