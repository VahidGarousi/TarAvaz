package ir.taravaz.home.data.repository

import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlaylistRepositoryImpl : PlaylistRepository {
    override suspend fun getPlaylist(): PlaylistSection =
        withContext(Dispatchers.IO) {
            TODO("")
        }
}
