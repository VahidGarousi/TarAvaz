package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Playable

data class PlayableUi(
    val id: String,
    val cover: String,
)

fun Playable.mapToPlayableUi(): PlayableUi =
    PlayableUi(
        id = id,
        cover = cover,
    )
