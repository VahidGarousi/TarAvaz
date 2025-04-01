package ir.taravaz.core.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProviderImpl : DispatcherProvider {
    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun main(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun default(): CoroutineDispatcher {
        return return Dispatchers.Default
    }

    override fun immediateMain(): CoroutineDispatcher {
        return Dispatchers.Main.immediate
    }
}
