package ir.taravaz.core.track.presentation.model

import ir.taravaz.core.track.domain.moel.LatestTracks
import ir.taravaz.core.track.domain.moel.Track

data class LatestTracksUi(
    val id: String,
    val title: String,
    val items: List<TrackUi>,
)

fun LatestTracks.asLatestTracksUi(): LatestTracksUi =
    LatestTracksUi(
        id = id,
        title = title,
        items = items.map(Track::mapToTrackUi),
    )
