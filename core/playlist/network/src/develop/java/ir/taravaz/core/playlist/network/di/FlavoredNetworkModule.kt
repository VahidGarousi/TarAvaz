package ir.taravaz.core.playlist.network.di

import ir.taravaz.core.playlist.data.source.RemotePlaylistDataSource
import ir.taravaz.core.playlist.network.ktor.KtorRemotePlaylistDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val flavoredPlaylistNetworkModule = module {
    single { KtorRemotePlaylistDataSource(get(), get()) } bind RemotePlaylistDataSource::class
}
