package ir.taravaz.playlist.di

import ir.taravaz.playlist.PlaylistViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val playlistModule = module {
    viewModelOf(::PlaylistViewModel)
}
