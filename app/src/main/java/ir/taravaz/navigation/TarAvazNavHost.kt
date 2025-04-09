package ir.taravaz.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import ir.taravaz.core.track.presentation.TrackNavType
import ir.taravaz.explore.navigation.exploreNavigation
import ir.taravaz.feature.track.navigation.navigateToTrack
import ir.taravaz.feature.track.navigation.trackScreen
import ir.taravaz.home.navigation.HomeBaseRoute
import ir.taravaz.home.navigation.homeNavigation
import ir.taravaz.playlist.navigation.playlistNavigation
import ir.taravaz.profile.navigation.profileNavigation
import ir.taravaz.ui.TarAvazAppState
import org.koin.compose.koinInject

@Composable
fun TarAvazNavHost(
    modifier: Modifier = Modifier,
    appState: TarAvazAppState,
) {
    val navController = appState.navController
    val trackNavType = koinInject<TrackNavType>()
    NavHost(
        navController = navController,
        startDestination = HomeBaseRoute,
        modifier = modifier,
    ) {
        homeNavigation(
            onTrackClick = navController::navigateToTrack,
        ) {
            trackScreen(
                trackNavType = trackNavType,
            )
        }
        playlistNavigation()
        exploreNavigation()
        profileNavigation()
    }
}
