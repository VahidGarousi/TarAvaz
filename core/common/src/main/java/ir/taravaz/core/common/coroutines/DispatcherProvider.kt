package ir.taravaz.core.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun io(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun immediateMain(): CoroutineDispatcher
}
