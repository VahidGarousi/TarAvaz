package garousi.dev.taravaz.home.presentation.popular_tracks

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import garousi.dev.taravaz.home.domain.model.Artist
import garousi.dev.taravaz.home.domain.model.Track
import java.util.UUID

internal class PopularTracksStateProvider : PreviewParameterProvider<PopularTrackUiState> {
    private val rezaBahram = Artist(
        id = UUID.randomUUID().toString(),
        name = "رضا بهرام"
    )
    private val shadmehrAghili = Artist(
        id = UUID.randomUUID().toString(),
        name = "شادمهر عقیلی"
    )
    private val tracks = arrayListOf<Track>().apply {
        add(
            Track(
                id = UUID.randomUUID().toString(),
                name = "گل مریم",
                duration = 256000,
                releaseDate = 256000,
                artist = rezaBahram,
                cover = "http://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
            )
        )
        add(
            Track(
                id = UUID.randomUUID().toString(),
                name = "قاضی",
                duration = 256000,
                releaseDate = 256000,
                artist =shadmehrAghili,
                cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
            )
        )
    }
    override val values: Sequence<PopularTrackUiState> = sequenceOf(
        PopularTrackUiState.Loading,
        PopularTrackUiState.Success(data = tracks),
        PopularTrackUiState.Failure.Unknown("خطا در دریافت اطلاعات")
    )
}