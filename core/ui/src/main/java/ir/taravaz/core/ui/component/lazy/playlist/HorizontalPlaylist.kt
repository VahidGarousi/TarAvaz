package ir.taravaz.core.ui.component.lazy.playlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.lazy.playlist.preview.LatestPlayablePreviewParameterProvider
import ir.taravaz.core.ui.component.model.PlaylistSectionUi

@Composable
fun HorizontalPlaylist(
    modifier: Modifier = Modifier,
    playlist: LoadableData<PlaylistSectionUi>,
) {
    Column(
        modifier = modifier,
    ) {
        LoadableComponent(
            loadableData = playlist,
            loading = {
                SectionHeaderLoading(
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(TarAvazTheme.spacing.space4))
                PlaylistInfoListLoading(
                    modifier = modifier.fillMaxWidth(),
                )
            },
            loaded = { playlist ->
                SectionHeader(
                    modifier = Modifier.fillMaxWidth(),
                    title = playlist.title,
                )
                PlaylistInfoList(
                    modifier = Modifier.fillMaxWidth(),
                    playlistInfos = playlist.infos,
                )
            },
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalPlaylistPreview(
    @PreviewParameter(LatestPlayablePreviewParameterProvider::class)
    parameter: LoadableData<PlaylistSectionUi>,
) {
    TarAvazPreview {
        HorizontalPlaylist(
            playlist = parameter,
        )
    }
}
