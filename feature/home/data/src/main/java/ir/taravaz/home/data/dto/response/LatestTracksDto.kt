package ir.taravaz.home.data.dto.response

import ir.taravaz.core.domain.model.LatestTracks
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

/**
 * Illegal input: Fields [id, title, items] are required for type with serial name 'ir.taravaz.home.data.dto.response.LatestTracksDto', but they were missing at path: $
 */
