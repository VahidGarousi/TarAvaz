package ir.taravaz.core.track.di

import ir.taravaz.core.track.network.di.trackNetworkModule
import ir.taravaz.core.track.presentation.di.trackPresentationModule
import org.koin.dsl.module

val trackCoreModules = module {
    includes(trackPresentationModule, trackNetworkModule)
}
