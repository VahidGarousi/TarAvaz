package ir.taravaz

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import ir.taravaz.di.appModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androix.startup.KoinStartup
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.logger.Level.DEBUG
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.koinConfiguration

@OptIn(KoinExperimentalAPI::class)
class TarAvazApplication :
    Application(),
    SingletonImageLoader.Factory,
    KoinStartup {
    val imageLoader: ImageLoader by inject()

    override fun onCreate() {
        super.onCreate()
    }

    override fun newImageLoader(context: PlatformContext): ImageLoader = imageLoader

    override fun onKoinStartup(): KoinConfiguration =
        koinConfiguration {
            androidContext(this@TarAvazApplication)
            androidLogger(DEBUG)
            modules(appModule)
        }
}
