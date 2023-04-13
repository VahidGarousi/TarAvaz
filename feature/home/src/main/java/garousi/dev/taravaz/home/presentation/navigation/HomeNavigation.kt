package garousi.dev.taravaz.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import garousi.dev.taravaz.home.presentation.Home

const val homeGraphRoute = "home_graph"
const val homeRoute = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeGraphRoute, navOptions)
}

fun NavGraphBuilder.homeGraph(
    navController: NavController,
    navigateToTrack: (String) -> Unit,
) {
    navigation(
        startDestination = homeRoute,
        route = homeGraphRoute
    ) {
        homeScreen(
            navController = navController,
            navigateToTrack = navigateToTrack
        )
    }
}


private fun NavGraphBuilder.homeScreen(
    navController: NavController,
    navigateToTrack: (String) -> Unit
) {
    composable(
        route = homeRoute
    ) {
        Home(
            navigateToTrack = navigateToTrack
        )
    }
}