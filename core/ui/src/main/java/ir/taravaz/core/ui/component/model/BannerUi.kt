package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.Banner

data class BannerUi(
    val id: Long,
    val image: String,
    val linkType: Long,
    val linkValue: String,
)

fun Banner.mapToBanner(): BannerUi =
    BannerUi(
        id = id,
        image = image,
        linkType = linkType,
        linkValue = linkValue,
    )

fun List<Banner>.mapToBannerUis(): List<BannerUi> = this.map(Banner::mapToBanner)
