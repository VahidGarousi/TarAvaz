package ir.taravaz.home.domain.repository

import ir.taravaz.core.domain.model.PlaylistSection

interface PlaylistRepository {
    suspend fun getPlaylist(): PlaylistSection
}
