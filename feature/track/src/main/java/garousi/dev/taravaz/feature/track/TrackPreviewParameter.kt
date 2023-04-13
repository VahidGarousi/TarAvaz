package garousi.dev.taravaz.feature.track

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import garousi.dev.taravaz.core.model.Artist
import garousi.dev.taravaz.core.model.Track
import java.util.UUID

class TrackPreviewParameter : PreviewParameterProvider<TrackUiState> {
    override val values: Sequence<TrackUiState>
        get() = sequenceOf(
            TrackUiState.Loading,
            TrackUiState.Track(
                Track(
                    id = UUID.randomUUID().toString(),
                    name = "گل مریم",
                    duration = 256000,
                    releaseDate = 256000,
                    artist = Artist(
                        id = UUID.randomUUID().toString(),
                        name = "رضا بهرام"
                    ),
                    cover = "http://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
                )
            ),
        )
}