package garousi.dev.taravaz.home.data.repository

import garousi.dev.taravaz.home.domain.model.Track
import garousi.dev.taravaz.home.domain.repository.TrackRepository
import javax.inject.Inject

class FakeTrackRepository @Inject constructor(

) : TrackRepository {
    override suspend fun getLatestTracks(): Result<List<Track>> {
        return Result.success(MockTrackGenerator.fakeTracks)
    }
}