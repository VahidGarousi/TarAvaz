package ir.taravaz.home.data.repository

import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.Playables
import ir.taravaz.home.domain.repository.TrackRepository

class TrackRepositoryImpl : TrackRepository {
    override suspend fun getLatestPlayables(): Playables {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayableBanners(): List<PlayableBanner> {
        TODO("Not yet implemented")
    }
}
