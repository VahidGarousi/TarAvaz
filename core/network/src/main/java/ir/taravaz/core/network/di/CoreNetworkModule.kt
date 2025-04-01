package ir.taravaz.core.network.di

import androidx.tracing.trace
import coil3.ImageLoader
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.svg.SvgDecoder
import coil3.util.DebugLogger
import io.ktor.client.HttpClient
import ir.taravaz.core.network.BuildConfig
import ir.taravaz.core.network.HttpClientFactory
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    single { Json { ignoreUnknownKeys = true } }
    single<HttpClient> {
        trace("TarAvazKtorHttpClient") {
            HttpClientFactory().build()
        }
    }
    single<ImageLoader> {
        trace("TarAvazImageLoader") {
            ImageLoader
                .Builder(androidApplication())
                .components {
                    add(
                        factory = KtorNetworkFetcherFactory(
                            httpClient = get<HttpClient>(),
                        ),
                    )
                    add(SvgDecoder.Factory())
                }.apply {
                    if (BuildConfig.DEBUG) {
                        logger(DebugLogger())
                    }
                }.build()
        }
    }
}
