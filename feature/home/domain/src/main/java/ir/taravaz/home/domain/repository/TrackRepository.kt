package ir.taravaz.home.domain.repository

import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.LatestTracks

interface TrackRepository {
    suspend fun getLatestTracks(): Result<LatestTracks, NetworkError>
    suspend fun getPlayableBanners(): List<PlayableBanner>
}
