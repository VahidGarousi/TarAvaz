package ir.taravaz.core.playlist.network.di

import ir.taravaz.core.playlist.data.source.RemotePlaylistDataSource
import ir.taravaz.core.playlist.network.DemoRemotePlaylistDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val flavoredPlaylistNetworkModule = module {
    singleOf<RemotePlaylistDataSource>(::DemoRemotePlaylistDataSource)
}
