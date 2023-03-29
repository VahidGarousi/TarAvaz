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

class FakeTrackRepository @Inject constructor(

) : TrackRepository {
    override suspend fun getLatestTracks(): Result<List<Track>> {
        return Result.success(arrayListOf<Track>().apply {
            add(
                Track(
                    id = UUID.randomUUID().toString(),
                    name = "گل مریم",
                    duration = 256000,
                    releaseDate = 256000,
                    artist = rezaBahram
                )
            )
            add(
                Track(
                    id = UUID.randomUUID().toString(),
                    name = "دور شدی",
                    duration = 256000,
                    releaseDate = 256000,
                    artist = shadmehrAghili
                )
            )
        })
    }
}