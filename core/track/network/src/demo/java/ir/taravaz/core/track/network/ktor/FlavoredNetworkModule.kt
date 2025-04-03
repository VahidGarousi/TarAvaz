package ir.taravaz.core.track.network.ktor

import ir.taravaz.core.track.data.source.RemoteTrackDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val flavoredNetworkModule = module {
    singleOf<RemoteTrackDataSource>(::DemoRemoteTrackDataSource)
}
