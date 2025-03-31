@file:Suppress("ReturnCount")

package ir.taravaz.home.data.api.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
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
        } catch (_: UnresolvedAddressException) {
            return Result.Failure(NetworkError.NO_INTERNET)
        } catch (_: SerializationException) {
            return Result.Failure(NetworkError.SERIALIZATION)
        }
        return response.toResult()
    }

    private suspend fun HttpResponse.toResult(): Result<LatestTracksDto, NetworkError> =
        when (status.value) {
            in HttpStatusCode.OK..HttpStatusCode.MULTIPLE_CHOICES -> handleSuccess()
            HttpStatusCode.UNAUTHORIZED -> Result.Failure(NetworkError.UNAUTHORIZED)
            HttpStatusCode.REQUEST_TIMEOUT -> Result.Failure(NetworkError.REQUEST_TIMEOUT)
            HttpStatusCode.CONFLICT -> Result.Failure(NetworkError.CONFLICT)
            HttpStatusCode.PAYLOAD_TOO_LARGE -> Result.Failure(NetworkError.PAYLOAD_TOO_LARGE)
            HttpStatusCode.TOO_MANY_REQUESTS -> Result.Failure(NetworkError.TOO_MANY_REQUESTS)
            in HttpStatusCode.INTERNAL_SERVER_ERROR..HttpStatusCode.NOT_IMPLEMENTED ->
                Result.Failure(
                    NetworkError.SERVER_ERROR,
                )

            else -> Result.Failure(NetworkError.UNKNOWN)
        }

    private suspend fun HttpResponse.handleSuccess(): Result<LatestTracksDto, NetworkError> =
        try {
            val data = body<ApiResponse<LatestTracksDto>>().data
            Result.Success(data)
        } catch (_: SerializationException) {
            Result.Failure(NetworkError.SERIALIZATION)
        }

    private object HttpStatusCode {
        const val OK = 200
        const val MULTIPLE_CHOICES = 300
        const val UNAUTHORIZED = 401
        const val REQUEST_TIMEOUT = 408
        const val CONFLICT = 409
        const val PAYLOAD_TOO_LARGE = 413
        const val TOO_MANY_REQUESTS = 429
        const val INTERNAL_SERVER_ERROR = 500
        const val NOT_IMPLEMENTED = 599
    }
}
