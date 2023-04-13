package garousi.dev.taravaz

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import garousi.dev.taravaz.feature.track.navigation.navigateToTrack
import garousi.dev.taravaz.feature.track.navigation.trackScreen
import garousi.dev.taravaz.home.presentation.navigation.homeGraph
import garousi.dev.taravaz.home.presentation.navigation.homeGraphRoute


@Composable
fun TarAvazNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeGraphRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph(
            navController = navController,
            navigateToTrack = { trackId ->
                navController.navigateToTrack(trackId)
            },
        )
        trackScreen(
            navController = navController
        )
    }
}

@Composable
fun TarAvazBottomBar() {

}
