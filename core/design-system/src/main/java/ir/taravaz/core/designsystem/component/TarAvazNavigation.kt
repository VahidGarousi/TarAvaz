@file:Suppress("LongParameterList")

package ir.taravaz.core.designsystem.component

import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.taravaz.core.designsystem.theme.TarAvazTheme

@Composable
fun TarAvazNavigationSuiteScaffold(
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    navigationSuiteItems: TarAvazNavigationSuiteScope.() -> Unit,
    content: @Composable () -> Unit,
) {
    val layoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)
    val navigationSuiteItemColors = NavigationSuiteItemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedIconColor = TarAvazTheme.colors.navigationContentColor,
            selectedTextColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedTextColor = TarAvazTheme.colors.navigationContentColor,
            indicatorColor = TarAvazTheme.colors.navigationIndicatorColor,
        ),
        navigationRailItemColors = NavigationRailItemDefaults.colors(
            selectedIconColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedIconColor = TarAvazTheme.colors.navigationContentColor,
            selectedTextColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedTextColor = TarAvazTheme.colors.navigationContentColor,
            indicatorColor = TarAvazTheme.colors.navigationIndicatorColor,
        ),
        navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedIconColor = TarAvazTheme.colors.navigationContentColor,
            selectedTextColor = TarAvazTheme.colors.navigationSelectedItemColor,
            unselectedTextColor = TarAvazTheme.colors.navigationContentColor,
        ),
    )
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            TarAvazNavigationSuiteScope(
                navigationSuiteScope = this,
                navigationSuiteItemColors = navigationSuiteItemColors,
            ).run(navigationSuiteItems)
        },
        layoutType = layoutType,
        containerColor = Color.DarkGray,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContentColor = TarAvazTheme.colors.navigationContentColor,
            navigationBarContainerColor = TarAvazTheme.colors.navigationContainerColor,
        ),
        modifier = modifier,
        content = content,
    )
}

/**
 * A wrapper around [NavigationSuiteScope] to declare navigation items.
 */
class TarAvazNavigationSuiteScope internal constructor(
    private val navigationSuiteScope: NavigationSuiteScope,
    private val navigationSuiteItemColors: NavigationSuiteItemColors,
) {
    fun item(
        selected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        icon: @Composable () -> Unit,
        selectedIcon: @Composable () -> Unit = icon,
        label: @Composable (() -> Unit)? = null,
    ) = navigationSuiteScope.item(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected) {
                selectedIcon()
            } else {
                icon()
            }
        },
        label = label,
        colors = navigationSuiteItemColors,
        modifier = modifier,
    )
}
