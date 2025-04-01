package ir.taravaz.home.data.di

import ir.taravaz.home.data.api.RemoteTrackDataSource
import ir.taravaz.home.data.api.ktor.KtorRemoteTrackDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val flavoredNetworkModule = module {
    single { KtorRemoteTrackDataSource(get(), get()) } bind RemoteTrackDataSource::class
}
