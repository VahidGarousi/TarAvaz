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
    val skeletonColor: Color,
    val navigationContentColor: Color,
    val navigationSelectedItemColor: Color,
    val navigationIndicatorColor: Color,
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
        skeletonColor: Color,
        navigationContentColor: Color,
        navigationSelectedItemColor: Color,
        navigationIndicatorColor: Color,
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
        skeletonColor = this.skeletonColor,
        navigationContentColor = this.navigationContentColor,
        navigationSelectedItemColor = this.navigationSelectedItemColor,
        navigationIndicatorColor = this.navigationIndicatorColor,
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
    skeletonColor: Color = TarAvazLightTokens.SkeletonColor,
    navigationContentColor: Color = TarAvazLightTokens.NavigationContentColor,
    navigationSelectedItemColor: Color = TarAvazLightTokens.NavigationSelectedItemColor,
    navigationIndicatorColor: Color = TarAvazLightTokens.NavigationIndicatorColor,
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
        skeletonColor = skeletonColor,
        navigationContentColor = navigationContentColor,
        navigationSelectedItemColor = navigationSelectedItemColor,
        navigationIndicatorColor = navigationIndicatorColor,
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
    skeletonColor: Color = TarAvazDarkTokens.SkeletonColor,
    navigationContentColor: Color = TarAvazDarkTokens.NavigationContentColor,
    navigationSelectedItemColor: Color = TarAvazDarkTokens.NavigationSelectedItemColor,
    navigationIndicatorColor: Color = TarAvazDarkTokens.NavigationIndicatorColor,
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
        skeletonColor = skeletonColor,
        navigationContentColor = navigationContentColor,
        navigationSelectedItemColor = navigationSelectedItemColor,
        navigationIndicatorColor = navigationIndicatorColor,
    )

internal val LocalTarAvazColors = staticCompositionLocalOf { tarAvazDarkColors() }
