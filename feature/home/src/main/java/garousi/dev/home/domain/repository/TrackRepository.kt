package garousi.dev.home.domain.repository

import garousi.dev.home.domain.model.Track

interface TrackRepository {
    suspend fun getLatestTracks(): Result<List<Track>>
}