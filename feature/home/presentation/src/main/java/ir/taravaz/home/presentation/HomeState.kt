package ir.taravaz.home.presentation

import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.PlayableBannerUi
import ir.taravaz.core.ui.component.model.PlaylistUi

data class HomeState(
    val playableBanners: LoadableData<List<PlayableBannerUi>> = LoadableData.Initial,
    val playlist: LoadableData<PlaylistUi> = LoadableData.Initial,
)
