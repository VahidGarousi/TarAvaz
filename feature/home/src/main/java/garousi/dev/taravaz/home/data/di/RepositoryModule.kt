package garousi.dev.taravaz.home.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import garousi.dev.taravaz.home.data.repository.FakeBannerRepository
import garousi.dev.taravaz.home.data.repository.FakeTrackRepository
import garousi.dev.taravaz.home.domain.repository.BannerRepository
import garousi.dev.taravaz.home.domain.repository.TrackRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsTrackRepository(
        impl: FakeTrackRepository
    ): TrackRepository


    @Binds
    @Singleton
    abstract fun bindsBannerRepository(
        impl: FakeBannerRepository
    ): BannerRepository

}