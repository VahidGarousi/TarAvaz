package ir.taravaz.core.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import ir.taravaz.core.common.constants.TarAvazAppConstants
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.SerializationException

suspend inline fun <reified Response : Any> HttpClient.get(
    route: String,
    queryParameters: Map<String, Any?> = mapOf(),
): Result<Response, DataError.Network> =
    safeCall {
        get {
            url(constructRoute(route))
            queryParameters.forEach { (key, value) ->
                parameter(key, value)
            }
        }
    }

suspend inline fun <reified T> safeCall(execute: () -> HttpResponse): Result<T, DataError.Network> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        e.printStackTrace()
        return Result.Failure(DataError.Network.NO_INTERNET)
    } catch (e: SerializationException) {
        e.printStackTrace()
        return Result.Failure(DataError.Network.SERIALIZATION)
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        return Result.Failure(DataError.Network.UNKNOWN)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, DataError.Network> =
    when (response.status.value) {
        in 200..299 -> Result.Success(response.body<T>())
        401 -> Result.Failure(DataError.Network.UNAUTHORIZED)
        408 -> Result.Failure(DataError.Network.REQUEST_TIMEOUT)
        409 -> Result.Failure(DataError.Network.CONFLICT)
        413 -> Result.Failure(DataError.Network.PAYLOAD_TOO_LARGE)
        429 -> Result.Failure(DataError.Network.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Failure(DataError.Network.SERVER_ERROR)
        else -> Result.Failure(DataError.Network.UNKNOWN)
    }

fun constructRoute(route: String): String =
    when {
        route.contains(TarAvazAppConstants.BASE_URL) -> route
        route.startsWith("/") -> TarAvazAppConstants.BASE_URL + route
        else -> TarAvazAppConstants.BASE_URL + "/$route"
    }
