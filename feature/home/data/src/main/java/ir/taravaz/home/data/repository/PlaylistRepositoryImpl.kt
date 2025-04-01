package ir.taravaz.home.data.repository

import io.ktor.client.HttpClient
import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository
import kotlinx.coroutines.withContext

class PlaylistRepositoryImpl(
    private val httpClient: HttpClient,
    private val dispatcherProvider: DispatcherProvider,
) : PlaylistRepository {
    override suspend fun getPlaylist(): Result<PlaylistSection, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            Result.Failure(DataError.Network.SERVER_ERROR)
        }
}
