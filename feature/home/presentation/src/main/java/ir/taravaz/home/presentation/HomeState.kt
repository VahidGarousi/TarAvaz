package ir.taravaz.home.presentation

import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableBannerUi

data class HomeState(
    val playableBanners: LoadableData<List<PlayableBannerUi>> = LoadableData.Initial,
)
