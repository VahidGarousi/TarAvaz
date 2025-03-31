package ir.taravaz.home.data.di

import ir.taravaz.home.data.api.TrackApi
import ir.taravaz.home.data.api.ktor.KtorTrackApi
import ir.taravaz.home.data.repository.PlaylistRepositoryImpl
import ir.taravaz.home.data.repository.TrackRepositoryImpl
import ir.taravaz.home.domain.repository.PlaylistRepository
import ir.taravaz.home.domain.repository.TrackRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeDataModule = module {
    single<TrackApi> {
        KtorTrackApi(get())
    }
    single<TrackRepository> {
        TrackRepositoryImpl(get())
    }
    singleOf<PlaylistRepository>(::PlaylistRepositoryImpl)
}
