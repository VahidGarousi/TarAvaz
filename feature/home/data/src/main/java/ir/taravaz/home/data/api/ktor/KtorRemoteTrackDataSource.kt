@file:Suppress("ReturnCount")

package ir.taravaz.home.data.api.ktor

import io.ktor.client.HttpClient
import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.network.ApiResponse
import ir.taravaz.core.network.get
import ir.taravaz.home.data.api.RemoteTrackDataSource
import ir.taravaz.home.data.dto.response.BannerDto
import ir.taravaz.home.data.dto.response.LatestTracksDto
import ir.taravaz.home.data.dto.response.mapToBanner
import ir.taravaz.home.data.dto.response.mapToLatestTracks
import kotlinx.coroutines.withContext

class KtorRemoteTrackDataSource(
    private val httpClient: HttpClient,
    private val dispatcherProvider: DispatcherProvider,
) : RemoteTrackDataSource {
    override suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient
                .get<ApiResponse<LatestTracksDto>>(
                    "/latest-tracks",
                ).map { latestTracksDto: ApiResponse<LatestTracksDto> ->
                    latestTracksDto.data.mapToLatestTracks()
                }
        }

    override suspend fun getBanners(): Result<List<Banner>, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient
                .get<ApiResponse<List<BannerDto>>>(
                    route = "/banners",
                ).map { bannersDto: ApiResponse<List<BannerDto>> ->
                    bannersDto.data.map(BannerDto::mapToBanner)
                }
        }
}
