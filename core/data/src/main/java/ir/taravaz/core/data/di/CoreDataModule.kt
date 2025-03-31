package ir.taravaz.core.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import ir.taravaz.core.data.createHttpClient
import org.koin.dsl.module

val coreDataModule = module {
    single<HttpClient> {
        createHttpClient(
            OkHttpEngine(
                OkHttpConfig(),
            ),
        )
    }
}
