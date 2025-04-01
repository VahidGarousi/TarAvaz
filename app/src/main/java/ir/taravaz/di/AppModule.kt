package ir.taravaz.di

import ir.taravaz.core.data.di.coreDataModule
import ir.taravaz.core.ui.di.coreUIModule
import ir.taravaz.home.di.homeModule
import org.koin.dsl.module

val featureModules = module {
    includes(homeModule)
}

val appModule = module {
    includes(coreDataModule, coreUIModule, featureModules)
}
