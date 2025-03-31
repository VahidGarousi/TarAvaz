package ir.taravaz.home.presentation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.carousel.PlayableCarouselPreviewParameterProvider
import ir.taravaz.core.ui.component.lazy.playable.preview.TopPlayListPreviewParameterProvider
import ir.taravaz.core.ui.component.lazy.playlist.preview.LatestPlayablePreviewParameterProvider
import ir.taravaz.core.ui.component.model.PlayablesUi
import ir.taravaz.home.presentation.HomeState

internal class HomeStatePreviewParameterProvider : PreviewParameterProvider<HomeState> {
    private val playableBannerProvider = PlayableCarouselPreviewParameterProvider()
    private val topPlaylistsProvider = TopPlayListPreviewParameterProvider()
    private val latestPlayablesProvider = LatestPlayablePreviewParameterProvider()
    override val values: Sequence<HomeState> = playableBannerProvider.values.flatMap { loadableData ->
        topPlaylistsProvider.values.flatMap { playlist: LoadableData<PlayablesUi> ->
            latestPlayablesProvider.values.map {
                HomeState(
                    banners = loadableData,
                    latestPlayables = playlist,
                    playlistSection = it,
                )
            }
        }
    }
}
