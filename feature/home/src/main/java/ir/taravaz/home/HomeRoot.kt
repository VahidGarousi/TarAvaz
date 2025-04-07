package ir.taravaz.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.playlist.presentation.component.HorizontalPlaylist
import ir.taravaz.core.playlist.presentation.model.PlaylistSectionUi
import ir.taravaz.core.track.presentation.component.HorizontalLatestTracks
import ir.taravaz.core.track.presentation.model.LatestTracksUi
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.model.BannerUi
import ir.taravaz.home.component.BannerCarousel
import ir.taravaz.home.preview.HomeStatePreviewParameterProvider
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoot(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        modifier = modifier.fillMaxSize(),
        state = state,
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        verticalSpacer()
        banners(
            banners = state.banners,
        )
        verticalSpacer()
        quickActions()
        verticalSpacer()
        latestTracks(
            latestTracks = state.latestTracks,
        )
        verticalSpacer()
        popularPlaylists(
            playlistSection = state.playlistSection,
        )
        verticalSpacer()
    }
}

private fun LazyListScope.latestTracks(latestTracks: LoadableData<LatestTracksUi>) {
    item {
        HorizontalLatestTracks(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = TarAvazTheme.spacing.space8,
                ),
            latestPlayables = latestTracks,
        )
    }
}

private fun LazyListScope.popularPlaylists(playlistSection: LoadableData<PlaylistSectionUi>) {
    item {
        HorizontalPlaylist(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = TarAvazTheme.spacing.space8,
                ),
            playlistSection = playlistSection,
        )
    }
}

private fun LazyListScope.verticalSpacer() {
    item {
        Spacer(
            modifier = Modifier.height(TarAvazTheme.spacing.space12),
        )
    }
}

private fun LazyListScope.quickActions() {
    item {
        QuickActions(
            modifier = Modifier
                .height(TarAvazTheme.spacing.space108)
                .padding(
                    TarAvazTheme.spacing.space8,
                ),
        )
    }
}

private fun LazyListScope.banners(banners: LoadableData<List<BannerUi>>) {
    item {
        BannerCarousel(
            modifier = Modifier.fillMaxWidth(),
            banners = banners,
            onClick = {
            },
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HomePreview(
    @PreviewParameter(HomeStatePreviewParameterProvider::class)
    parameter: HomeState,
) {
    TarAvazPreview {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            state = parameter,
        )
    }
}
