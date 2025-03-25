package ir.taravaz.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import ir.taravaz.core.designsystem.icon.TarAvazIcon
import ir.taravaz.home.presentation.navigation.HomeBaseRoute
import ir.taravaz.home.presentation.navigation.HomeRoute
import kotlin.reflect.KClass
import ir.taravaz.home.presentation.R as homeR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        selectedIcon = TarAvazIcon.Home,
        unselectedIcon = TarAvazIcon.Home,
        iconTextId = homeR.string.feature_home_title,
        titleTextId = homeR.string.feature_home_title,
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class,
    ),
}
