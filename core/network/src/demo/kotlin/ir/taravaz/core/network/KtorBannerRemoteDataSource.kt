package ir.taravaz.core.network

import io.ktor.client.HttpClient
import ir.taravaz.core.common.coroutines.DispatcherProvider
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.data.model.BannerDto
import ir.taravaz.core.data.source.BannerRemoteDataSource
import kotlinx.coroutines.withContext

class KtorBannerRemoteDataSource(
    private val httpClient: HttpClient,
    private val dispatcherProvider: DispatcherProvider,
) : BannerRemoteDataSource {
    override suspend fun getBanners(): Result<List<BannerDto>, DataError.Network> =
        withContext(dispatcherProvider.io()) {
            httpClient
                .get<ApiResponse<List<BannerDto>>>(
                    route = "/banners",
                ).map { it.data }
        }
}
