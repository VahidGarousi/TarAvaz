package ir.taravaz.core.track.domain.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.track.domain.moel.Banner
import ir.taravaz.core.track.domain.moel.LatestTracks

interface TrackRepository {
    suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network>
}
