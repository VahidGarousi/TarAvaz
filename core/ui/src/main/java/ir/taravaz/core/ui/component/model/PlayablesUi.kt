package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.Track

data class PlayablesUi(
    val id: String,
    val title: String,
    val items: List<TrackUi>,
)

fun LatestTracks.mapToPlayablesUi(): PlayablesUi =
    PlayablesUi(
        id = id,
        title = title,
        items = items.map(Track::mapToPlayableUi),
    )
