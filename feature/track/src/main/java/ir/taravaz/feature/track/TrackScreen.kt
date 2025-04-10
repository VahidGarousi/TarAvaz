package ir.taravaz.feature.track

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import ir.taravaz.core.designsystem.preview.MediumPhonePreviews
import ir.taravaz.core.designsystem.theme.TarAvazPreview
import ir.taravaz.core.designsystem.theme.TarAvazTheme
import ir.taravaz.core.ui.component.loadableComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrackScreen(viewModel: TrackViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TrackScreen(
        state = state,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TrackScreen(
    modifier: Modifier = Modifier,
    state: TrackState,
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text("Vahid")
                },
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues),
        ) {
            loadableComponent(
                loadableData = state.trackUi,
                loaded = { track ->
                    trackCover(
                        imageUrl = track.imageUrl,
                    )
                    trackInfo()
                    trackSlider()
                    playerControls()
                    trackDetails()
                },
            )
        }
    }
}

private fun LazyListScope.trackDetails() {
    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Filled.Shuffle,
                    contentDescription = null,
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space36),
            ) {
                Icon(
                    imageVector = Icons.Filled.SkipNext,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space56),
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayCircleFilled,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space36),
            ) {
                Icon(
                    imageVector = Icons.Filled.SkipPrevious,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Filled.Replay,
                    contentDescription = null,
                )
            }
        }
    }
}

private fun LazyListScope.playerControls() {
    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Filled.Shuffle,
                    contentDescription = null,
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space36),
            ) {
                Icon(
                    imageVector = Icons.Filled.SkipNext,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space56),
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayCircleFilled,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.size(TarAvazTheme.spacing.space36),
            ) {
                Icon(
                    imageVector = Icons.Filled.SkipPrevious,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            IconButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Filled.Replay,
                    contentDescription = null,
                )
            }
        }
    }
}

private fun LazyListScope.trackSlider() {
    item {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Slider(
                modifier = Modifier.fillMaxWidth(),
                valueRange = 0f..100f,
                value = 50f,
                onValueChange = {
                },
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "02:53",
                )
                Text(
                    text = "00:00",
                )
            }
        }
    }
}

private fun LazyListScope.trackInfo() {
    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = "Track title",
                )
                Text(
                    text = "Track title",
                )
            }
            Row(
                modifier = Modifier,
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                    )
                }
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

private fun LazyListScope.trackCover(imageUrl: String) {
    item {
        TrackCover(
            imageUrl = imageUrl,
        )
    }
}

@Composable
private fun TrackCover(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    Box(
        modifier = modifier
            .padding(TarAvazTheme.spacing.space56)
            .fillMaxWidth()
            .aspectRatio(TrackScreenConfig.COVER_BOX_RATIO),
    ) {
        AsyncImage(
            modifier = Modifier
                .aspectRatio(TrackScreenConfig.COVER_RATIO)
                .clip(TarAvazTheme.shapes.rectangle16Radius),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }
}

private object TrackScreenConfig {
    const val COVER_BOX_RATIO = 9f / 16f
    const val COVER_RATIO = 1f
}

@MediumPhonePreviews
@Composable
private fun TrackScreenPreview(
    @PreviewParameter(TrackStatePreviewParameterProvider::class)
    trackState: TrackState,
) {
    TarAvazPreview {
        TrackScreen(
            modifier = Modifier.fillMaxSize(),
            state = trackState,
        )
    }
}
