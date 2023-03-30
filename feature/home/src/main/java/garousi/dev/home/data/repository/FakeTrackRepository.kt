package garousi.dev.home.data.repository

import garousi.dev.home.domain.model.Track
import garousi.dev.home.domain.repository.TrackRepository
import javax.inject.Inject

class FakeTrackRepository @Inject constructor(

) : TrackRepository {
    override suspend fun getLatestTracks(): Result<List<Track>> {
        return Result.success(MockGenerator.fakeTracks)
    }
}