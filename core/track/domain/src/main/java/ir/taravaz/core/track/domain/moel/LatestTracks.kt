package ir.taravaz.core.track.domain.moel

data class LatestTracks(
    val id: String,
    val title: String,
    val items : List<Track>
)
