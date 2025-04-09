package ir.taravaz.core.ui.component

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import ir.taravaz.core.common.util.Error

@Composable
fun <T> LoadableComponent(
    loadableData: LoadableData<T>,
    loading: @Composable () -> Unit = {},
    failureContent: @Composable (Error) -> Unit = {},
    loaded: @Composable (T) -> Unit = {},
    initial: @Composable () -> Unit = {},
) {
    when (loadableData) {
        is LoadableData.Loading -> loading()
        is LoadableData.Error -> failureContent(loadableData.error)
        is LoadableData.Loaded -> loaded(loadableData.data)
        is LoadableData.Initial -> initial()
    }
}

fun <T> LazyListScope.loadableComponent(
    loadableData: LoadableData<T>,
    loading: LazyListScope.() -> Unit = {},
    failureContent: LazyListScope.(Error) -> Unit = {},
    loaded: LazyListScope.(T) -> Unit = {},
    initial: LazyListScope.() -> Unit = {},
) {
    when (loadableData) {
        is LoadableData.Loading -> loading()
        is LoadableData.Error -> failureContent(loadableData.error)
        is LoadableData.Loaded -> loaded(loadableData.data)
        is LoadableData.Initial -> initial()
    }
}
