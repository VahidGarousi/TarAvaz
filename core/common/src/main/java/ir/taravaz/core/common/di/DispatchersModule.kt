package ir.taravaz.core.common.di

import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.coroutines.DispatcherProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dispatchersKoinModule = module {
    singleOf<DispatcherProvider>(::DispatcherProviderImpl)
}
