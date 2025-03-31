package ir.taravaz.core.domain.model

data class LatestTracks(
    val id: String,
    val title: String,
    val items : List<Track>
)
