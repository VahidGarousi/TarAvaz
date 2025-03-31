package ir.taravaz.home.presentation

import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.model.BannerUi
import ir.taravaz.core.ui.component.model.LatestTracksUi
import ir.taravaz.core.ui.component.model.PlaylistSectionUi

data class HomeState(
    val banners: LoadableData<List<BannerUi>> = LoadableData.Initial,
    val playlistSection: LoadableData<PlaylistSectionUi> = LoadableData.Initial,
    val latestTracks: LoadableData<LatestTracksUi> = LoadableData.Initial,
)
