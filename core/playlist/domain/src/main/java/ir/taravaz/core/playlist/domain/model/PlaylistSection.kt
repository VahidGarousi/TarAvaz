package ir.taravaz.core.playlist.domain.model

import ir.taravaz.core.track.domain.moel.Track

data class PlaylistSection(
    val title: String,
    val infos : List<PlaylistInfo>
)

data class PlaylistInfo(
    val id: String,
    val title: String,
)

data class Playlist(
    val info: PlaylistInfo,
    val items : List<Track>
)
