package ir.taravaz.core.playlist.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.playlist.presentation.component.preview.PlaylistSectionPreviewParameterProvider
import ir.taravaz.core.playlist.presentation.model.PlaylistSectionUi
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.lazy.playlist.SectionHeader

@Composable
fun HorizontalPlaylist(
    modifier: Modifier = Modifier,
    playlistSection: LoadableData<PlaylistSectionUi>,
) {
    Column(
        modifier = modifier,
    ) {
        LoadableComponent(
            loadableData = playlistSection,
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
    @PreviewParameter(PlaylistSectionPreviewParameterProvider::class)
    parameter: LoadableData<PlaylistSectionUi>,
) {
    TarAvazPreview {
        HorizontalPlaylist(
            playlistSection = parameter,
        )
    }
}
