package ir.taravaz.core.common.util



inline fun <T, E : Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Failure -> Result.Failure(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T, E : Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map { }
}

inline fun <T, E : Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Failure -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Failure -> {
            action(error)
            this
        }

        is Result.Success -> this
    }
}

typealias EmptyResult<E> = Result<Unit, E>
