package ir.taravaz.home.domain.di

import ir.taravaz.home.domain.GetBannersUseCase
import ir.taravaz.home.domain.GetLatestTracksUseCase
import ir.taravaz.home.domain.GetPlaylistSectionUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeDomainModule = module {
    factoryOf(::GetBannersUseCase)
    factoryOf(::GetPlaylistSectionUseCase)
    factoryOf(::GetLatestTracksUseCase)
}
