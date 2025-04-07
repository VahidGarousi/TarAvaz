package ir.taravaz.core.data.di

import ir.taravaz.core.common.di.coroutineScopesKoinModule
import ir.taravaz.core.common.di.dispatchersKoinModule
import ir.taravaz.core.data.repository.BannerRepositoryImpl
import ir.taravaz.core.domain.di.coreDomainModule
import ir.taravaz.core.domain.usecase.BannerRepository
import org.koin.dsl.module

val coreDataModule = module {
    includes(coreDomainModule, coroutineScopesKoinModule, dispatchersKoinModule)
    single<BannerRepository> {
        BannerRepositoryImpl(get())
    }
}
