package garousi.dev.home.data.repository

import garousi.dev.home.domain.model.Artist
import garousi.dev.home.domain.model.Track
import garousi.dev.home.domain.repository.TrackRepository
import java.util.UUID
import javax.inject.Inject

val rezaBahram = Artist(
    id = UUID.randomUUID().toString(),
    name = "رضا بهرام"
)
val shadmehrAghili = Artist(
    id = UUID.randomUUID().toString(),
    name = "شادمهر عقیلی"
)

val fakeTracks = arrayListOf<Track>().apply {
    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "گل مریم",
            duration = 256000,
            releaseDate = 256000,
            artist = rezaBahram,
            cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
        )
    )
    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "قاضی",
            duration = 256000,
            releaseDate = 256000,
            artist = shadmehrAghili,
            cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
        )
    )
    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "گل مریم",
            duration = 256000,
            releaseDate = 256000,
            artist = rezaBahram,
            cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
        )
    )
    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "قاضی",
            duration = 256000,
            releaseDate = 256000,
            artist = shadmehrAghili,
            cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
        )
    )

    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "گل مریم",
            duration = 256000,
            releaseDate = 256000,
            artist = rezaBahram,
            cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
        )
    )
    add(
        Track(
            id = UUID.randomUUID().toString(),
            name = "قاضی",
            duration = 256000,
            releaseDate = 256000,
            artist = shadmehrAghili,
            cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
        )
    )
}


class FakeTrackRepository @Inject constructor(

) : TrackRepository {
    override suspend fun getLatestTracks(): Result<List<Track>> {
        return Result.success(fakeTracks)
    }
}