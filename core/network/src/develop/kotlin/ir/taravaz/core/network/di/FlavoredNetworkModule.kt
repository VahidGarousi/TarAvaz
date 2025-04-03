package ir.taravaz.core.network.di

import ir.taravaz.core.data.source.BannerRemoteDataSource
import ir.taravaz.core.network.KtorBannerRemoteDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val flavoredNetworkModule = module {
    single { KtorBannerRemoteDataSource(get(), get()) } bind BannerRemoteDataSource::class
}
