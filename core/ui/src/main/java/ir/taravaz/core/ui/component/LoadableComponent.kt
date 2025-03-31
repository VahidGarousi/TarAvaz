package ir.taravaz.core.ui.component

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
