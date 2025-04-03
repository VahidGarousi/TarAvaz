package ir.taravaz.core.data.model

import ir.taravaz.core.domain.model.Banner
import kotlinx.serialization.Serializable

@Serializable
data class BannerDto(
    val id: Long,
    val image: String,
    val linkType: Long,
    val linkValue: String,
)

fun BannerDto.mapToBanner(): Banner =
    Banner(
        id = id,
        image = image,
        linkType = linkType,
        linkValue = linkValue,
    )

fun List<BannerDto>.mapToBanners(): List<Banner> = this.map(BannerDto::mapToBanner)
