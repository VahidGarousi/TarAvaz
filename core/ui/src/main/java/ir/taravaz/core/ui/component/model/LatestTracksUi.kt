package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.Track

data class LatestTracksUi(
    val id: String,
    val title: String,
    val items: List<TrackUi>,
)

fun LatestTracks.mapToPlayablesUi(): LatestTracksUi =
    LatestTracksUi(
        id = id,
        title = title,
        items = items.map(Track::mapToPlayableUi),
    )
