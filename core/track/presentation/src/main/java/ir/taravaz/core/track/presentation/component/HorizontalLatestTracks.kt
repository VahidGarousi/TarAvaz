package ir.taravaz.core.track.presentation.component

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
import ir.taravaz.core.track.presentation.component.preview.TracksPreviewParameterProvider
import ir.taravaz.core.track.presentation.model.LatestTracksUi
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.lazy.playlist.SectionHeader
import ir.taravaz.core.ui.component.lazy.playlist.SectionHeaderLoading

@Composable
fun HorizontalLatestTracks(
    modifier: Modifier = Modifier,
    latestPlayables: LoadableData<LatestTracksUi>,
    onTrackClick: (TrackUi) -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        LoadableComponent(
            loadableData = latestPlayables,
            loading = {
                SectionHeaderLoading(
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(TarAvazTheme.spacing.space4))
                LazyPlayableListLoading(
                    modifier = modifier.fillMaxWidth(),
                )
            },
            loaded = { latestPlayables ->
                SectionHeader(
                    modifier = Modifier.fillMaxWidth(),
                    title = latestPlayables.title,
                )
                HorizontalTracks(
                    modifier = modifier,
                    tracks = latestPlayables.items,
                    onTrackClick = onTrackClick,
                )
            },
            failureContent = {
                SectionHeader(
                    modifier = Modifier.fillMaxWidth(),
                    title = "خطایی رخ داده است",
                )
                Spacer(modifier = Modifier.height(TarAvazTheme.spacing.space4))
            },
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalPlayableListPreview(
    @PreviewParameter(TracksPreviewParameterProvider::class)
    parameter: LoadableData<LatestTracksUi>,
) {
    TarAvazPreview {
        HorizontalLatestTracks(
            modifier = Modifier.fillMaxWidth(),
            latestPlayables = parameter,
            onTrackClick = {},
        )
    }
}
