package ir.taravaz.home

import ir.taravaz.core.playlist.presentation.model.PlaylistSectionUi
import ir.taravaz.core.track.presentation.model.LatestTracksUi
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.model.BannerUi

data class HomeState(
    val banners: LoadableData<List<BannerUi>> = LoadableData.Initial,
    val playlistSection: LoadableData<PlaylistSectionUi> = LoadableData.Initial,
    val latestTracks: LoadableData<LatestTracksUi> = LoadableData.Initial,
)
