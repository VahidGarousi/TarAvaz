package ir.taravaz.feature.track.di

import ir.taravaz.feature.track.TrackViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val trackModule = module {
    viewModelOf(::TrackViewModel)
}
