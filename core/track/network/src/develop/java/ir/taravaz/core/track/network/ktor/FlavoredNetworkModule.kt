package ir.taravaz.core.track.network.ktor

import ir.taravaz.core.track.data.source.RemoteTrackDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val flavoredNetworkModule = module {
    single { KtorRemoteTrackDataSource(get(), get()) } bind RemoteTrackDataSource::class
}
