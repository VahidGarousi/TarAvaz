package ir.taravaz.core.track.domain.di

import ir.taravaz.core.track.domain.usecase.GetLatestTracksUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val trackDomainModule = module {
    factoryOf(::GetLatestTracksUseCase)
}
