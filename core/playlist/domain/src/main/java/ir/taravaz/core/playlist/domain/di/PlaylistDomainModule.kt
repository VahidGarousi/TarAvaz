package ir.taravaz.core.playlist.domain.di

import ir.taravaz.core.playlist.domain.usecase.GetPlaylistSectionUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val playlistDomainModule = module {
    factoryOf(::GetPlaylistSectionUseCase)
}
