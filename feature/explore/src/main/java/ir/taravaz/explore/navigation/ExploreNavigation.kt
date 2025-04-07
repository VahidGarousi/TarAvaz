package ir.taravaz.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ir.taravaz.explore.ExploreRoot
import kotlinx.serialization.Serializable

@Serializable
data object ExploreRoute

@Serializable
data object ExploreBaseRoute

fun NavController.navigateToExplore(navOptions: NavOptions) = navigate(route = ExploreRoute, navOptions)

fun NavGraphBuilder.exploreNavigation() {
    navigation<ExploreBaseRoute>(
        startDestination = ExploreRoute,
    ) {
        composable<ExploreRoute> {
            ExploreRoot()
        }
    }
}
