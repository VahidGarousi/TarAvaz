package ir.taravaz.core.track.data.dto

import ir.taravaz.core.track.domain.moel.LatestTracks
import kotlinx.serialization.Serializable

@Serializable
data class LatestTracksDto(
    val id: String,
    val title: String,
    val items: List<TrackDto>,
)

fun LatestTracksDto.mapToLatestTracks(): LatestTracks =
    LatestTracks(
        id = id,
        title = title,
        items = items.map(TrackDto::mapToTrack),
    )
