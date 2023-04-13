package garousi.dev.taravaz.feature.track.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import garousi.dev.taravaz.feature.track.TrackScreen

internal const val trackIdArg = "trackId"

private const val trackRoute = "track/{$trackIdArg}"

fun NavController.navigateToTrack(
    trackId: String
) {
    this.navigate("track/$trackId")
}

fun NavGraphBuilder.trackScreen(
    navController: NavHostController
) {
    composable(
        route = trackRoute,
        arguments = listOf(
            navArgument(trackIdArg) { type = NavType.StringType }
        )
    ) {
        TrackScreen(
            navigateUp = navController::navigateUp
        )
    }
}

internal class TrackArgs(val trackId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(checkNotNull(savedStateHandle[trackIdArg]) as String)
}