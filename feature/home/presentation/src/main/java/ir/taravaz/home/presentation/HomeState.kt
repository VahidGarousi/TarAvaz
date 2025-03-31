package ir.taravaz.home.presentation

import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.BannerUi
import ir.taravaz.core.ui.component.model.PlayablesUi
import ir.taravaz.core.ui.component.model.PlaylistSectionUi

data class HomeState(
    val banners: LoadableData<List<BannerUi>> = LoadableData.Initial,
    val playlistSection: LoadableData<PlaylistSectionUi> = LoadableData.Initial,
    val latestPlayables: LoadableData<PlayablesUi> = LoadableData.Initial,
)
