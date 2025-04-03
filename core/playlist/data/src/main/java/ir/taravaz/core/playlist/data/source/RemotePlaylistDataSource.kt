package ir.taravaz.core.playlist.data.source

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.playlist.data.dto.PlaylistDto
import ir.taravaz.core.playlist.data.dto.PlaylistSectionDto

interface RemotePlaylistDataSource {
    suspend fun getPopularPlaylistSection(): Result<PlaylistSectionDto, DataError.Network>

    suspend fun getPlaylistDetail(playlistId: String): Result<PlaylistDto, DataError.Network>
}
