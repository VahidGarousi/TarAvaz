package ir.taravaz.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import ir.taravaz.explore.presentation.navigation.exploreNavigation
import ir.taravaz.home.presentation.navigation.HomeBaseRoute
import ir.taravaz.home.presentation.navigation.homeNavigation
import ir.taravaz.playlist.presentation.navigation.playlistNavigation
import ir.taravaz.profile.presentation.navigation.profileNavigation
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
