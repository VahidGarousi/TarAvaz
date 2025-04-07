package ir.taravaz.core.track.data.dto

import ir.taravaz.core.track.domain.moel.Track
import kotlinx.serialization.Serializable

@Serializable
data class TrackDto(
    val id: String,
    val name: String,
    val description: String,
    val artist: String,
    val imageUrl: String,
    val releaseDate: String,
)

fun TrackDto.mapToTrack(): Track =
    Track(
        id = id,
        name = name,
        description = description,
        artist = artist,
        imageUrl = imageUrl,
        releaseDate = releaseDate,
    )
