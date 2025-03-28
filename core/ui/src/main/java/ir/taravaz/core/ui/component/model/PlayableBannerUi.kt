package ir.taravaz.core.ui.component.model

import ir.taravaz.core.domain.model.PlayableBanner

data class PlayableBannerUi(
    val cover: String = "",
)

fun PlayableBanner.mapToPlayableBannerUi(): PlayableBannerUi =
    PlayableBannerUi(
        cover = imageUrl,
    )
