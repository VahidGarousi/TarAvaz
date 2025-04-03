package ir.taravaz.core.network.di

import ir.taravaz.core.data.source.BannerRemoteDataSource
import ir.taravaz.core.network.DemoRemoteBannerDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val flavoredNetworkModule = module {
    singleOf<BannerRemoteDataSource>(::DemoRemoteBannerDataSource)
}
