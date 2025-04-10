@file:Suppress("MatchingDeclarationName")

package ir.taravaz.feature.track.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import ir.taravaz.core.track.presentation.TrackNavType
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.feature.track.TrackScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data class TrackRoute(
    val trackUi: TrackUi,
)

fun NavController.navigateToTrack(
    trackUi: TrackUi,
    navOptions: NavOptionsBuilder.() -> Unit = {},
) {
    navigate(route = TrackRoute(trackUi = trackUi)) {
        navOptions()
    }
}

fun NavGraphBuilder.trackScreen(trackNavType: TrackNavType) {
    composable<TrackRoute>(
        typeMap = mapOf(
            typeOf<TrackUi>() to trackNavType,
        ),
    ) {
        TrackScreen()
    }
}
