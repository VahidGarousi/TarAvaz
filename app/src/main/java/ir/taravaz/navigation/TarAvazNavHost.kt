package ir.taravaz.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import ir.taravaz.explore.navigation.exploreNavigation
import ir.taravaz.home.navigation.HomeBaseRoute
import ir.taravaz.home.navigation.homeNavigation
import ir.taravaz.playlist.navigation.playlistNavigation
import ir.taravaz.profile.navigation.profileNavigation
import ir.taravaz.ui.TarAvazAppState

@Composable
fun TarAvazNavHost(
    modifier: Modifier = Modifier,
    appState: TarAvazAppState,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeBaseRoute,
        modifier = modifier,
    ) {
        homeNavigation()
        playlistNavigation()
        exploreNavigation()
        profileNavigation()
    }
}
