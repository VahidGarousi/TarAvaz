package ir.taravaz.core.domain.model

data class Playlist(
    val id: String,
    val items : List<Playable>
)
