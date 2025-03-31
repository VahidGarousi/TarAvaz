package ir.taravaz.home.data.api

import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.common.util.Result
import ir.taravaz.home.data.dto.response.LatestTracksDto

interface TrackApi {
    suspend fun getLatestTracks(): Result<LatestTracksDto, NetworkError>
}
