package ir.taravaz.home.data.repository

import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.home.data.api.TrackApi
import ir.taravaz.home.data.dto.response.LatestTracksDto
import ir.taravaz.home.data.dto.response.mapToLatestTracks
import ir.taravaz.home.domain.repository.TrackRepository

class TrackRepositoryImpl(
    private val trackApi: TrackApi,
) : TrackRepository {
    override suspend fun getLatestTracks(): Result<LatestTracks, NetworkError> =
        trackApi.getLatestTracks().map(LatestTracksDto::mapToLatestTracks)

    override suspend fun getPlayableBanners(): List<PlayableBanner> {
        TODO("Not yet implemented")
    }
}
