package garousi.dev.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import garousi.dev.home.data.FakeTrackRepository
import garousi.dev.home.domain.repository.TrackRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TestRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsTrackRepository(
        impl: FakeTrackRepository
    ): TrackRepository
}