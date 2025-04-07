package ir.taravaz.core.playlist.data.dto

import ir.taravaz.core.track.data.dto.TrackDto
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistSectionDto(
    val title: String,
    val infos: List<PlaylistInfoDto>,
)

@Serializable
data class PlaylistInfoDto(
    val id: String,
    val title: String,
)

@Serializable
data class PlaylistDto(
    val info: PlaylistInfoDto,
    val items: List<TrackDto>,
)
