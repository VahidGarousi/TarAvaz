package garousi.dev.taravaz.core.ui.components.horizontal_tracks

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import garousi.dev.taravaz.core.model.Artist
import garousi.dev.taravaz.core.model.Track
import java.util.UUID

class HorizontalTracksUiStateProvider : PreviewParameterProvider<HorizontalTracksUiState> {
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
    override val values: Sequence<HorizontalTracksUiState> = sequenceOf(
        HorizontalTracksUiState.Loading,
        HorizontalTracksUiState.Success(data = tracks),
        HorizontalTracksUiState.Failure.Unknown("خطا در دریافت اطلاعات")
    )
}