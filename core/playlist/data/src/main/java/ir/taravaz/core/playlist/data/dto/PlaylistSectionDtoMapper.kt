package ir.taravaz.core.playlist.data.dto

import ir.taravaz.core.playlist.domain.model.Playlist
import ir.taravaz.core.playlist.domain.model.PlaylistInfo
import ir.taravaz.core.playlist.domain.model.PlaylistSection
import ir.taravaz.core.track.data.dto.mapToTrack

fun PlaylistSectionDto.mapToPlaylistSection(): PlaylistSection =
    PlaylistSection(
        title = title,
        infos = infos.map { it.mapToPlaylistInfo() },
    )

fun PlaylistInfoDto.mapToPlaylistInfo(): PlaylistInfo =
    PlaylistInfo(
        id = id,
        title = title,
    )

fun PlaylistDto.mapToPlaylist(): Playlist =
    Playlist(
        info = info.mapToPlaylistInfo(),
        items = items.map { it.mapToTrack() },
    )
