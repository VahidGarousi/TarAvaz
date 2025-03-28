package ir.taravaz.home.presentation.di

import ir.taravaz.home.domain.GetLatestPlayablesUseCase
import ir.taravaz.home.domain.GetPlayableBannersUseCase
import ir.taravaz.home.domain.GetPlaylistUseCase
import ir.taravaz.home.presentation.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homePresentationModule = module {
    viewModelOf(::HomeViewModel)
    singleOf(::GetPlayableBannersUseCase)
    singleOf(::GetPlaylistUseCase)
    singleOf(::GetLatestPlayablesUseCase)
}
