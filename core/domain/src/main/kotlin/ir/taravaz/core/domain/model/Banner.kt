package ir.taravaz.core.domain.model

data class Banner(
    val id: Long,
    val image: String,
    val linkType: Long,
    val linkValue: String,
)
