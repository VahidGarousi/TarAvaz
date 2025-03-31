package ir.taravaz.core.domain.model

data class  Track(
    val id: String,
    val name: String,
    val releaseDate: String,
    val description: String,
    val artist: String,
    val imageUrl: String,
)
