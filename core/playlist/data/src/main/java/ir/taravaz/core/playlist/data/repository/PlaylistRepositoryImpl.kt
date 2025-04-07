package ir.taravaz.core.playlist.data.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.playlist.data.dto.mapToPlaylist
import ir.taravaz.core.playlist.data.dto.mapToPlaylistSection
import ir.taravaz.core.playlist.data.source.RemotePlaylistDataSource
import ir.taravaz.core.playlist.domain.model.Playlist
import ir.taravaz.core.playlist.domain.model.PlaylistSection
import ir.taravaz.core.playlist.domain.repository.PlaylistRepository

class PlaylistRepositoryImpl(
    private val remotePlaylistDataSource: RemotePlaylistDataSource,
) : PlaylistRepository {
    override suspend fun getPopularPlaylistSection(): Result<PlaylistSection, DataError.Network> =
        remotePlaylistDataSource.getPopularPlaylistSection().map {
            it.mapToPlaylistSection()
        }

    override suspend fun getPlaylistDetail(playlistId: String): Result<Playlist, DataError.Network> =
        remotePlaylistDataSource.getPlaylistDetail(playlistId = playlistId).map {
            it.mapToPlaylist()
        }
}
