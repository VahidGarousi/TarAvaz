package garousi.dev.taravaz.feature.track.domain

import garousi.dev.taravaz.core.model.Artist
import garousi.dev.taravaz.core.model.Track
import java.util.UUID
import javax.inject.Inject

class GetTrackByIdUseCase @Inject constructor(){
    operator fun invoke(trackId: String): GetTrackByIdResult {
        val artist = Artist(
            id = UUID.randomUUID().toString(), name = "شادمهر عقیلی"
        )
        val track = Track(
            id = UUID.randomUUID().toString(),
            name = "قاضی",
            duration = 256000,
            releaseDate = 256000,
            artist = artist,
            cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
        )
        return GetTrackByIdResult.Success(track)
    }
}


sealed interface GetTrackByIdResult {
    data class Success(val track: Track) : GetTrackByIdResult
    data class Error(val message: String) : GetTrackByIdResult
}