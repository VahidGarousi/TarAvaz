package ir.taravaz.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import ir.taravaz.core.designsystem.icon.TarAvazIcon
import ir.taravaz.explore.navigation.ExploreRoute
import ir.taravaz.home.navigation.HomeBaseRoute
import ir.taravaz.home.navigation.HomeRoute
import ir.taravaz.playlist.navigation.PlaylistRoute
import ir.taravaz.profile.navigation.ProfileRoute
import kotlin.reflect.KClass
import ir.taravaz.explore.R as exploreR
import ir.taravaz.home.R as homeR
import ir.taravaz.playlist.R as playlistR
import ir.taravaz.profile.R as profileR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        selectedIcon = TarAvazIcon.Home,
        unselectedIcon = TarAvazIcon.Home,
        iconTextId = homeR.string.feature_home_presentation_title,
        titleTextId = homeR.string.feature_home_presentation_title,
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class,
    ),
    PLAYLIST(
        selectedIcon = TarAvazIcon.Playlist,
        unselectedIcon = TarAvazIcon.Playlist,
        iconTextId = playlistR.string.feature_playlist_presentation_title,
        titleTextId = playlistR.string.feature_playlist_presentation_title,
        route = PlaylistRoute::class,
    ),
    EXPLORE(
        selectedIcon = TarAvazIcon.Explore,
        unselectedIcon = TarAvazIcon.Explore,
        iconTextId = exploreR.string.feature_explore_presentation_title,
        titleTextId = exploreR.string.feature_explore_presentation_title,
        route = ExploreRoute::class,
    ),
    PROFILE(
        selectedIcon = TarAvazIcon.Profile,
        unselectedIcon = TarAvazIcon.Profile,
        iconTextId = profileR.string.feature_profile_presentation_title,
        titleTextId = profileR.string.feature_profile_presentation_title,
        route = ProfileRoute::class,
    ),
}
