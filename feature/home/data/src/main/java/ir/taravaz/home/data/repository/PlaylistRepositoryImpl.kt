package ir.taravaz.home.data.repository

import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository

class PlaylistRepositoryImpl : PlaylistRepository {
    override suspend fun getPlaylist(): PlaylistSection {
        TODO("Not yet implemented")
    }
}
