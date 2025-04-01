package ir.taravaz.home.domain.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.PlaylistSection

interface PlaylistRepository {
    suspend fun getPlaylist(): Result<PlaylistSection, DataError.Network>
}
