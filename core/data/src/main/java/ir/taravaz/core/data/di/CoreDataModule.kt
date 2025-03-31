package ir.taravaz.core.data.di

import io.ktor.client.HttpClient
import ir.taravaz.core.data.createHttpClient
import org.koin.dsl.module

val coreDataModule = module {
    single<HttpClient> {
        createHttpClient()
    }
}
