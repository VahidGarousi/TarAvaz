package ir.taravaz.core.ui.component

import androidx.compose.runtime.Composable

@Composable
fun <T> LoadableComponent(
    loadableData: LoadableData<T>,
    loading: @Composable () -> Unit = {},
    error: @Composable (Throwable) -> Unit = {},
    loaded: @Composable (T) -> Unit = {},
    initial: @Composable () -> Unit = {},
) {
    when (loadableData) {
        is LoadableData.Loading -> loading()
        is LoadableData.Error -> error(loadableData.throwable)
        is LoadableData.Loaded -> loaded(loadableData.data)
        is LoadableData.Initial -> initial()
    }
}
