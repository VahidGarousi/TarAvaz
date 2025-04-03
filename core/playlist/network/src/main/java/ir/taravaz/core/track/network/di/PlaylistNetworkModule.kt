package ir.taravaz.core.track.network.di

import ir.taravaz.core.playlist.data.di.playlistDataModule
import ir.taravaz.core.playlist.network.di.flavoredPlaylistNetworkModule
import org.koin.dsl.module

val playlistNetworkModule = module {
    includes(playlistDataModule, flavoredPlaylistNetworkModule)
}
