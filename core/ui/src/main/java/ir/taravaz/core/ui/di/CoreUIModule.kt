package ir.taravaz.core.ui.di

import ir.taravaz.core.ui.component.handler.ApiCallHandler
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreUIModule = module {
    singleOf(::ApiCallHandler)
}
