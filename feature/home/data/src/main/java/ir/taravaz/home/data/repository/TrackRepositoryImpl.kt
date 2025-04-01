package ir.taravaz.home.data.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.home.data.api.RemoteTrackDataSource
import ir.taravaz.home.domain.repository.TrackRepository

class TrackRepositoryImpl(
    private val remoteTrackDataSource: RemoteTrackDataSource,
) : TrackRepository {
    override suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network> = remoteTrackDataSource.getLatestTracks()

    override suspend fun getBanners(): Result<List<Banner>, DataError.Network> = remoteTrackDataSource.getBanners()
}
