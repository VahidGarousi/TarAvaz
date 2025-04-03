package ir.taravaz.core.track.domain.moel

data class  Track(
    val id: String,
    val name: String,
    val releaseDate: String,
    val description: String,
    val artist: String,
    val imageUrl: String,
)
