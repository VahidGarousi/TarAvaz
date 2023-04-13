package garousi.dev.taravaz.navigation

import garousi.dev.taravaz.R
import garousi.dev.taravaz.core.design_system.theme.Icon

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int
) {
    PROFILE(
        selectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_profile),
        unselectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_profile),
        iconTextId = R.string.profile,
        titleTextId = R.string.profile
    ),
    TRACKS(
        selectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_tracks),
        unselectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_tracks),
        iconTextId = R.string.tracks,
        titleTextId = R.string.tracks
    ),
    HOME(
        selectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_home),
        unselectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_home),
        iconTextId = R.string.home,
        titleTextId = R.string.home
    ),
    DISCOVERY(
        selectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_discovery),
        unselectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_discovery),
        iconTextId = R.string.discovery,
        titleTextId = R.string.discovery
    ),
    PLAYLIST(
        selectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_playlist),
        unselectedIcon = Icon.DrawableResourceIcon(R.drawable.ic_playlist),
        iconTextId = R.string.playlist,
        titleTextId = R.string.playlist
    )
}