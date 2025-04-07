package ir.taravaz.core.track.presentation.model

import ir.taravaz.core.track.domain.moel.Track

data class TrackUi(
    val id: String,
    val artistName: String,
    val name: String,
    val imageUrl: String,
)

fun Track.mapToTrackUi(): TrackUi =
    TrackUi(
        id = id,
        imageUrl = imageUrl,
        artistName = artist,
        name = name,
    )
