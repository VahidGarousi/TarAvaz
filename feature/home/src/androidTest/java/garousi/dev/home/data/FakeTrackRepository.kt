package garousi.dev.home.data

import garousi.dev.home.data.repository.MockGenerator
import garousi.dev.home.domain.model.Track
import garousi.dev.home.domain.repository.TrackRepository

class FakeTrackRepository  : TrackRepository {

    private var fakeTracks = mutableListOf<Track>()
    private var shouldReturnNetworkError = false
    private var shouldReturnEmptyList = false

    init {
        fakeTracks = MockGenerator.fakeTracks
    }

    fun setShouldReturnNetworkError(value: Boolean) {
        this.shouldReturnNetworkError = value
    }

    fun setShouldReturnEmptyList(value: Boolean) {
        this.shouldReturnEmptyList = value
    }

    override suspend fun getLatestTracks(): Result<List<Track>> {
        return if (shouldReturnNetworkError) {
            Result.failure(Throwable("Error Occurred"))
        } else {
            if (shouldReturnEmptyList) {
                Result.success(emptyList())
            } else
                Result.success(fakeTracks)
        }
    }
}