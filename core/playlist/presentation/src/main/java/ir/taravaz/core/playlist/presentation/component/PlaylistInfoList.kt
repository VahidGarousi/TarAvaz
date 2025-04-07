package ir.taravaz.core.playlist.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.playlist.presentation.component.preview.PlaylistInfoPreviewParameterProvider
import ir.taravaz.core.playlist.presentation.model.PlaylistInfoUi

@Composable
fun PlaylistInfoList(
    modifier: Modifier = Modifier,
    playlistInfos: List<PlaylistInfoUi> = emptyList(),
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(TarAvazTheme.spacing.space8),
    ) {
        items(
            items = playlistInfos,
        ) { information ->
            PlaylistInfo(
                information = information,
            )
        }
    }
}

@MediumPhonePreviews
@Composable
private fun PlaylistInfoListPreview(
    @PreviewParameter(PlaylistInfoPreviewParameterProvider::class)
    parameter: List<PlaylistInfoUi>,
) {
    TarAvazPreview {
        PlaylistInfoList(
            playlistInfos = parameter,
        )
    }
}
