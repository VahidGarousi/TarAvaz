package ir.taravaz.home.data.di

import ir.taravaz.home.data.repository.PlaylistRepositoryImpl
import ir.taravaz.home.data.repository.TrackRepositoryImpl
import ir.taravaz.home.domain.repository.PlaylistRepository
import ir.taravaz.home.domain.repository.TrackRepository
import org.koin.dsl.module

val homeDataModule = module {
    includes(flavoredNetworkModule)
    single<TrackRepository> {
        TrackRepositoryImpl(get())
    }
    single<PlaylistRepository> {
        PlaylistRepositoryImpl(get(), get())
    }
}
