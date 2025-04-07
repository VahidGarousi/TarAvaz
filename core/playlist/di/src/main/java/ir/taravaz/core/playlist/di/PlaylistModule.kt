package ir.taravaz.core.playlist.di

import ir.taravaz.core.playlist.presentation.di.playlistPresentationModule
import ir.taravaz.core.track.network.di.playlistNetworkModule
import org.koin.dsl.module

val playlistCoreModules = module {
    includes(playlistPresentationModule, playlistNetworkModule)
}
