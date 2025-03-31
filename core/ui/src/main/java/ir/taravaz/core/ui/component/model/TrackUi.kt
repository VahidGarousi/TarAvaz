package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Track

data class TrackUi(
    val id: String,
    val artistName: String,
    val name: String,
    val imageUrl: String,
)

fun Track.mapToPlayableUi(): TrackUi =
    TrackUi(
        id = id,
        imageUrl = imageUrl,
        artistName = "",
        name = "",
    )
