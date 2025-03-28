package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Playable
import ir.taravaz.core.domain.model.Playlist

data class PlaylistUi(
    val id: String,
    val items: List<PlayableUi>,
)

fun Playlist.mapToPlaylistUi(): PlaylistUi =
    PlaylistUi(
        id = id,
        items = items.map(Playable::mapToPlayableUi),
    )
