package ir.taravaz.core.track.data.di

import ir.taravaz.core.track.data.repository.TrackRepositoryImpl
import ir.taravaz.core.track.domain.di.trackDomainModule
import ir.taravaz.core.track.domain.repository.TrackRepository
import org.koin.dsl.module

val trackDataModule = module {
    includes(trackDomainModule)
    single<TrackRepository> {
        TrackRepositoryImpl(get())
    }
}
