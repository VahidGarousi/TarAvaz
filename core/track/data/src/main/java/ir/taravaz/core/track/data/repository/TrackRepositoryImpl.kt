package ir.taravaz.core.track.data.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.track.data.dto.mapToLatestTracks
import ir.taravaz.core.track.data.source.RemoteTrackDataSource
import ir.taravaz.core.track.domain.moel.LatestTracks
import ir.taravaz.core.track.domain.repository.TrackRepository

class TrackRepositoryImpl(
    private val remoteTrackDataSource: RemoteTrackDataSource,
) : TrackRepository {
    override suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network> =
        remoteTrackDataSource.getLatestTracks().map {
            it.mapToLatestTracks()
        }
}
