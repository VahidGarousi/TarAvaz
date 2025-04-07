package ir.taravaz.core.playlist.network.ktor

import io.ktor.client.HttpClient
import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.network.ApiResponse
import ir.taravaz.core.network.get
import ir.taravaz.core.playlist.data.dto.PlaylistDto
import ir.taravaz.core.playlist.data.dto.PlaylistSectionDto
import ir.taravaz.core.playlist.data.source.RemotePlaylistDataSource
import kotlinx.coroutines.withContext

class KtorRemotePlaylistDataSource(
    private val httpClient: HttpClient,
    private val dispatcherProvider: DispatcherProvider,
) : RemotePlaylistDataSource {
    override suspend fun getPopularPlaylistSection(): Result<PlaylistSectionDto, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient.get<ApiResponse<PlaylistSectionDto>>("/popular-playlists").map { it.data }
        }

    override suspend fun getPlaylistDetail(playlistId: String): Result<PlaylistDto, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient.get<ApiResponse<PlaylistDto>>("/playlist/{id}").map { it.data }
        }
}
