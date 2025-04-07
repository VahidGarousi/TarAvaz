package ir.taravaz.core.domain.di

import ir.taravaz.core.domain.usecase.GetBannersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val coreDomainModule = module {
    factoryOf(::GetBannersUseCase)
}
