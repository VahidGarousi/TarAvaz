package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Playable
import ir.taravaz.core.domain.model.Playlist
import ir.taravaz.core.domain.model.PlaylistInfo
import ir.taravaz.core.domain.model.PlaylistSection

data class PlaylistSectionUi(
    val title: String,
    val infos: List<PlaylistInfoUi>,
)

data class PlaylistInfoUi(
    val id: String,
    val title: String,
)

data class PlaylistUi(
    val playlistInfo: PlaylistInfoUi,
    val items: List<PlayableUi>,
)

fun Playlist.mapToPlaylistUi(): PlaylistUi =
    PlaylistUi(
        playlistInfo = info.mapToPlaylistInfoUi(),
        items = items.map(Playable::mapToPlayableUi),
    )

fun PlaylistSection.mapToPlaylistInfoUi(): PlaylistSectionUi =
    PlaylistSectionUi(
        title = title,
        infos = infos.map(PlaylistInfo::mapToPlaylistInfoUi),
    )

fun PlaylistInfo.mapToPlaylistInfoUi(): PlaylistInfoUi =
    PlaylistInfoUi(
        id = id,
        title = title,
    )
