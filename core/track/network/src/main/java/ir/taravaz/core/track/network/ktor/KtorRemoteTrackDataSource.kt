package ir.taravaz.core.track.network.ktor

import io.ktor.client.HttpClient
import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.network.ApiResponse
import ir.taravaz.core.network.get
import ir.taravaz.core.track.data.dto.LatestTracksDto
import ir.taravaz.core.track.data.source.RemoteTrackDataSource
import kotlinx.coroutines.withContext

class KtorRemoteTrackDataSource(
    private val httpClient: HttpClient,
    private val dispatcherProvider: DispatcherProvider,
) : RemoteTrackDataSource {
    override suspend fun getLatestTracks(): Result<LatestTracksDto, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient
                .get<ApiResponse<LatestTracksDto>>(
                    "/latest-tracks",
                ).map { latestTracksDto: ApiResponse<LatestTracksDto> ->
                    latestTracksDto.data
                }
        }
}
