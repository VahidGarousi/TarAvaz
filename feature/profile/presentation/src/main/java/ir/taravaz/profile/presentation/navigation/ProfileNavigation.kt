package ir.taravaz.profile.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ir.taravaz.profile.presentation.ProfileRoot
import kotlinx.serialization.Serializable

@Serializable
data object ProfileRoute

@Serializable
data object ProfileBaseRoute

fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(route = ProfileRoute, navOptions)

fun NavGraphBuilder.profileNavigation() {
    navigation<ProfileBaseRoute>(
        startDestination = ProfileRoute,
    ) {
        composable<ProfileRoute> {
            ProfileRoot()
        }
    }
}
