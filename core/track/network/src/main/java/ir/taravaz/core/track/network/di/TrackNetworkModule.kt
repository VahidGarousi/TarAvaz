package ir.taravaz.core.track.network.di

import ir.taravaz.core.track.data.di.trackDataModule
import ir.taravaz.core.track.network.ktor.flavoredNetworkModule
import org.koin.dsl.module

val trackNetworkModule = module {
    includes(trackDataModule, flavoredNetworkModule)
}
