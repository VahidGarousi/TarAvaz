package ir.taravaz.core.ui.component
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.Error as ErrorResult

sealed class LoadableData<out T> {
    abstract val data: T?

    data object Initial : LoadableData<Nothing>() {
        override val data = null
    }

    data object Loading : LoadableData<Nothing>() {
        override val data = null
    }

    data class Loaded<T>(
        override val data: T,
    ) : LoadableData<T>()

    data class Error(
        val error: ErrorResult,
    ) : LoadableData<Nothing>() {
        override val data = null
    }
}

val LoadableData<*>.isLoading: Boolean
    get() = this is LoadableData.Loading

fun <T> LoadableData<T>.copy(data: T? = this.data): LoadableData<T> =
    when (this) {
        is LoadableData.Error -> LoadableData.Error(error = error)
        is LoadableData.Initial -> LoadableData.Initial
        is LoadableData.Loaded<T> -> {
            if (data != null) {
                this.copy(data = data)
            } else {
                this.copy()
            }
        }
        is LoadableData.Loading -> LoadableData.Loading
    }

inline fun <T, E : ErrorResult, R> Result<T, E>.map(map: (T) -> R): LoadableData<R> =
    when (this) {
        is Result.Failure<E> -> LoadableData.Error(error = error)
        is Result.Success<T> -> LoadableData.Loaded(data = map(this.data))
    }
