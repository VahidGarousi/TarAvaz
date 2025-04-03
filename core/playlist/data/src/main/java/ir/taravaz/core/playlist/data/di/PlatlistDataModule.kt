package ir.taravaz.core.playlist.data.di

import ir.taravaz.core.playlist.data.repository.PlaylistRepositoryImpl
import ir.taravaz.core.playlist.domain.di.playlistDomainModule
import ir.taravaz.core.playlist.domain.repository.PlaylistRepository
import org.koin.dsl.module

val playlistDataModule = module {
    includes(playlistDomainModule)
    single<PlaylistRepository> {
        PlaylistRepositoryImpl(get())
    }
}
