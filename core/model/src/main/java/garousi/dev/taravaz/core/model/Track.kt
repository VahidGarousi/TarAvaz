package garousi.dev.taravaz.core.model

data class Track(
    val id: String,
    val name: String,
    val cover: String,
    val duration: Long,
    val releaseDate: Long,
    val artist: Artist
)
