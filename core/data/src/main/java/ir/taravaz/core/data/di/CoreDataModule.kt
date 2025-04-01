package ir.taravaz.core.data.di

import ir.taravaz.core.common.di.coroutineScopesKoinModule
import ir.taravaz.core.common.di.dispatchersKoinModule
import ir.taravaz.core.network.di.networkModule
import org.koin.dsl.module

val coreDataModule = module {
    includes(coroutineScopesKoinModule, dispatchersKoinModule, networkModule)
}
