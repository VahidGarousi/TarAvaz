package ir.taravaz.playlist.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navigation
import ir.taravaz.playlist.presentation.PlaylistRoot
import kotlinx.serialization.Serializable

@Serializable
data object PlaylistRoute

@Serializable
data object PlaylistBaseRoute

fun NavController.navigateToPlaylist(navOptions: NavOptions) = navigate(route = PlaylistRoute, navOptions)

fun NavGraphBuilder.playlistNavigation() {
    navigation<PlaylistBaseRoute>(
        startDestination = PlaylistRoute,
    ) {
        composable<PlaylistRoute> {
            PlaylistRoot()
        }
    }
}
