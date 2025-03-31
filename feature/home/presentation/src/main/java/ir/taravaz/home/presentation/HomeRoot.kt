package ir.taravaz.home.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.carousel.BannerCarousel
import ir.taravaz.core.ui.component.lazy.playable.HorizontalPlayableList
import ir.taravaz.core.ui.component.lazy.playlist.HorizontalPlaylist
import ir.taravaz.core.ui.component.model.BannerUi
import ir.taravaz.core.ui.component.model.PlayablesUi
import ir.taravaz.core.ui.component.model.PlaylistSectionUi
import ir.taravaz.home.presentation.preview.HomeStatePreviewParameterProvider
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
        contentPadding = PaddingValues(
            TarAvazTheme.spacing.space16,
        ),
    ) {
        banners(
            banners = state.banners,
        )
        verticalSpacer()
        quickActions()
        verticalSpacer()
        horizontalPlayablePlaylists(
            playlist = state.playlistSection,
        )
        verticalSpacer()
        horizontalPlayableList(
            latestPlayables = state.latestPlayables,
        )
    }
}

private fun LazyListScope.horizontalPlayableList(latestPlayables: LoadableData<PlayablesUi>) {
    item {
        HorizontalPlayableList(
            modifier = Modifier.fillMaxWidth(),
            latestPlayables = latestPlayables,
        )
    }
}

private fun LazyListScope.horizontalPlayablePlaylists(playlist: LoadableData<PlaylistSectionUi>) {
    item {
        HorizontalPlaylist(
            modifier = Modifier.fillMaxWidth(),
            playlist = playlist,
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
        QuickActions()
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
