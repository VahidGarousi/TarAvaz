@file:Suppress("TooGenericExceptionCaught")

package ir.taravaz.core.ui.component.handler

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result

class ApiCallHandler {
    suspend inline operator fun <T> invoke(
        block: suspend () -> Result<T, DataError.Network>,
        onLoading: () -> Unit = {},
        onSuccess: (T) -> Unit = {},
        onError: (DataError.Network) -> Unit = {},
    ) {
        onLoading()
        when (val result = block()) {
            is Result.Success -> onSuccess(result.data)
            is Result.Failure -> onError(result.error)
        }
    }
}

suspend inline fun <T> ApiCallHandler.suspendRunCatching(
    crossinline block: suspend () -> T,
    crossinline onError: (Throwable) -> DataError.Network,
): Result<T, DataError.Network> =
    try {
        Result.Success(block())
    } catch (exception: Exception) {
        Result.Failure(onError(exception))
    }
