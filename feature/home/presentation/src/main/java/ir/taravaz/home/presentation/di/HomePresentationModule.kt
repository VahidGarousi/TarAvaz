package ir.taravaz.home.presentation.di

import ir.taravaz.home.domain.GetBannersUseCase
import ir.taravaz.home.domain.GetLatestTracksUseCase
import ir.taravaz.home.domain.GetPlaylistSectionUseCase
import ir.taravaz.home.presentation.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homePresentationModule = module {
    viewModelOf(::HomeViewModel)
    singleOf(::GetBannersUseCase)
    singleOf(::GetPlaylistSectionUseCase)
    singleOf(::GetLatestTracksUseCase)
}
