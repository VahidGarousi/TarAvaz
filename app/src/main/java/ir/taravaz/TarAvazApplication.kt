package ir.taravaz

import android.app.Application
import ir.taravaz.home.presentation.di.homePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TarAvazApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TarAvazApplication)
            androidLogger()
            modules(homePresentationModule)
        }
    }
}
