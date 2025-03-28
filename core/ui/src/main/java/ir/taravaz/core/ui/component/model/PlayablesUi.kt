package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Playable
import ir.taravaz.core.domain.model.Playables

data class PlayablesUi(
    val id: String,
    val title: String,
    val items: List<PlayableUi>,
)

fun Playables.mapToPlayablesUi(): PlayablesUi =
    PlayablesUi(
        id = id,
        title = title,
        items = items.map(Playable::mapToPlayableUi),
    )
