package ir.taravaz.di

import ir.taravaz.core.network.di.coreNetworkModule
import ir.taravaz.core.playlist.di.playlistCoreModules
import ir.taravaz.core.track.di.trackCoreModules
import ir.taravaz.core.ui.di.coreUIModule
import ir.taravaz.home.di.homeModule
import ir.taravaz.playlist.di.playlistModule
import org.koin.dsl.module

val coreModules = module {
    includes(coreNetworkModule, coreUIModule, trackCoreModules, playlistCoreModules)
}
val featureModules = module {
    includes(homeModule, playlistModule)
}

val appModule = module {
    includes(coreModules, featureModules)
}
