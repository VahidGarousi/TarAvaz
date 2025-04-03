package ir.taravaz.core.playlist.domain.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.playlist.domain.model.Playlist
import ir.taravaz.core.playlist.domain.model.PlaylistSection

interface PlaylistRepository {
    suspend fun getPopularPlaylistSection(): Result<PlaylistSection, DataError.Network>
    suspend fun getPlaylistDetail(playlistId: String): Result<Playlist, DataError.Network>
}
