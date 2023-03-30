package garousi.dev.home.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import garousi.dev.home.data.repository.FakeTrackRepository
import garousi.dev.home.domain.repository.TrackRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsTrackRepository(
        impl: FakeTrackRepository
    ): TrackRepository
}