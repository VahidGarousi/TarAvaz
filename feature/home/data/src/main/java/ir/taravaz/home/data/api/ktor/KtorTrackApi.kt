package ir.taravaz.home.data.api.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.data.ApiResponse
import ir.taravaz.home.data.api.TrackApi
import ir.taravaz.home.data.dto.response.LatestTracksDto
import kotlinx.serialization.SerializationException

class KtorTrackApi(
    private val httpClient: HttpClient,
) : TrackApi {
    override suspend fun getLatestTracks(): Result<LatestTracksDto, NetworkError> {
        val response = try {
            httpClient.get(urlString = "latest-tracks")
        } catch (exception: UnresolvedAddressException) {
            return Result.Failure(NetworkError.NO_INTERNET)
        } catch (exception: SerializationException) {
            return Result.Failure(NetworkError.SERIALIZATION)
        }
        return when (response.status.value) {
            in 200..299 -> {
                val data = response.body<ApiResponse<LatestTracksDto>>().data
                Result.Success(data = data)
            }

            401 -> Result.Failure(NetworkError.UNAUTHORIZED)
            408 -> Result.Failure(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Failure(NetworkError.CONFLICT)
            413 -> Result.Failure(NetworkError.PAYLOAD_TOO_LARGE)
            429 -> Result.Failure(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> Result.Failure(NetworkError.SERVER_ERROR)
            else -> Result.Failure(NetworkError.UNKNOWN)
        }
    }
}
