package ir.taravaz.core.data.source

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.data.model.BannerDto

interface BannerRemoteDataSource {
    suspend fun getBanners(): Result<List<BannerDto>, DataError.Network>
}
