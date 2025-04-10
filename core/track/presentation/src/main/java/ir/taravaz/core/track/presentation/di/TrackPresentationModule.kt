package ir.taravaz.core.track.presentation.di

import ir.taravaz.core.track.presentation.TrackNavType
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val trackPresentationModule = module {
    factoryOf(::TrackNavType)
}
