package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.PlayableBanner

data class BannerUi(
    val cover: String = "",
)

fun PlayableBanner.mapToPlayableBannerUi(): BannerUi =
    BannerUi(
        cover = imageUrl,
    )
