package ir.taravaz.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.home.HomeRoot
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object HomeBaseRoute

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.homeNavigation(
    onTrackClick: (TrackUi) -> Unit,
    trackDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<HomeBaseRoute>(
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            HomeRoot(
                onTrackClick = onTrackClick,
            )
        }
        trackDestination()
    }
}
