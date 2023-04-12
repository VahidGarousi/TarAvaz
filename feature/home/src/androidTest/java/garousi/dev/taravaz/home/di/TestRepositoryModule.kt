package garousi.dev.taravaz.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import garousi.dev.taravaz.home.data.FakeTrackRepository
import garousi.dev.taravaz.home.domain.repository.TrackRepository
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