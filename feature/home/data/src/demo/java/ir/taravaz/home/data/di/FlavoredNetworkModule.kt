package ir.taravaz.home.data.di

import ir.taravaz.home.data.DemoRemoteTrackDataSource
import ir.taravaz.home.data.api.RemoteTrackDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val flavoredNetworkModule = module {
    singleOf<RemoteTrackDataSource>(::DemoRemoteTrackDataSource)
}
