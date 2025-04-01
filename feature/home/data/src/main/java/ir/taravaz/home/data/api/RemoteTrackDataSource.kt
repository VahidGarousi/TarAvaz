package ir.taravaz.home.data.api

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.model.LatestTracks

interface RemoteTrackDataSource {
    suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network>

    suspend fun getBanners(): Result<List<Banner>, DataError.Network>
}
