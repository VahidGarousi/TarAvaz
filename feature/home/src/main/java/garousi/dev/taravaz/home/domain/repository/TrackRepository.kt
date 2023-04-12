package garousi.dev.taravaz.home.domain.repository

import garousi.dev.taravaz.home.domain.model.Track

interface TrackRepository {
    suspend fun getLatestTracks(): Result<List<Track>>
}