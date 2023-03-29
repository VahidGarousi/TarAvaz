package garousi.dev.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import garousi.dev.home.presentation.Home

const val homeGraphRoute = "home_graph"
const val homeRoute = "home"


fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        startDestination = homeRoute,
        route = homeGraphRoute
    ) {
        addHome(navController = navController)
    }
}


private fun NavGraphBuilder.addHome(
    navController: NavController
) {
    composable(
        route = homeRoute
    ) {
        Home()
    }
}