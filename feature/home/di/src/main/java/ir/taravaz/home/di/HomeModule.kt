package ir.taravaz.home.di

import ir.taravaz.home.data.di.flavoredNetworkModule
import ir.taravaz.home.data.di.homeDataModule
import ir.taravaz.home.domain.di.homeDomainModule
import ir.taravaz.home.presentation.di.homePresentationModule
import org.koin.dsl.module

val homeModule = module {
    includes(homePresentationModule, homeDomainModule, homeDataModule, flavoredNetworkModule)
}
