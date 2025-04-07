package ir.taravaz.core.playlist.presentation.model

import ir.taravaz.core.playlist.domain.model.Playlist
import ir.taravaz.core.playlist.domain.model.PlaylistInfo
import ir.taravaz.core.playlist.domain.model.PlaylistSection
import ir.taravaz.core.track.domain.moel.Track
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.track.presentation.model.mapToTrackUi

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
    val items: List<TrackUi>,
)

fun Playlist.mapToPlaylistUi(): PlaylistUi =
    PlaylistUi(
        playlistInfo = info.mapToPlaylistInfoUi(),
        items = items.map(Track::mapToTrackUi),
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
