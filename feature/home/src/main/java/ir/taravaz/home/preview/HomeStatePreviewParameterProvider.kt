package ir.taravaz.home.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import ir.taravaz.core.playlist.presentation.component.preview.PlaylistSectionPreviewParameterProvider
import ir.taravaz.core.track.presentation.component.preview.TracksPreviewParameterProvider
import ir.taravaz.home.HomeState
import ir.taravaz.home.component.preview.BannerCarouselPreviewParameter

internal class HomeStatePreviewParameterProvider : PreviewParameterProvider<HomeState> {
    private val bannerCarouselPreviewProvider = BannerCarouselPreviewParameter()
    private val topPlaylistsProvider = TracksPreviewParameterProvider()
    private val playlistSectionProvider = PlaylistSectionPreviewParameterProvider()
    override val values: Sequence<HomeState> = topPlaylistsProvider.values.flatMap { loadableData ->
        bannerCarouselPreviewProvider.values.flatMap { banners ->
            playlistSectionProvider.values.map { playlistSection ->
                HomeState(
                    latestTracks = loadableData,
                    banners = banners,
                    playlistSection = playlistSection,
                )
            }
        }
    }
}
