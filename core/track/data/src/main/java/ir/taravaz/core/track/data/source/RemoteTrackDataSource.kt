package ir.taravaz.core.track.data.source

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.track.data.dto.LatestTracksDto

interface RemoteTrackDataSource {
    suspend fun getLatestTracks(): Result<LatestTracksDto, DataError.Network>
}
