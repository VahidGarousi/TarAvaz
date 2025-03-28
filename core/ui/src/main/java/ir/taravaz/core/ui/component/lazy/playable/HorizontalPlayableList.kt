package ir.taravaz.core.ui.component.lazy.playable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.ui.component.LoadableComponent
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.component.lazy.playable.preview.TopPlayListPreviewParameterProvider
import ir.taravaz.core.ui.component.lazy.playlist.SectionHeader
import ir.taravaz.core.ui.component.model.PlayablesUi

@Composable
fun HorizontalPlayableList(
    modifier: Modifier = Modifier,
    latestPlayables: LoadableData<PlayablesUi>,
) {
    Column(
        modifier = modifier,
    ) {
        LoadableComponent(
            loadableData = latestPlayables,
            loaded = { latestPlayables ->
                SectionHeader(
                    modifier = Modifier.fillMaxWidth(),
                    title = latestPlayables.title,
                )
                LazyPlayableList(
                    modifier = modifier,
                    latestPlayables = latestPlayables.items,
                )
            },
        )
    }
}

@MediumPhonePreviews
@Composable
private fun HorizontalPlayableListPreview(
    @PreviewParameter(TopPlayListPreviewParameterProvider::class)
    parameter: LoadableData<PlayablesUi>,
) {
    TarAvazPreview {
        HorizontalPlayableList(
            modifier = Modifier.fillMaxWidth(),
            latestPlayables = parameter,
        )
    }
}
