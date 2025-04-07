package ir.taravaz.core.data.repository

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.common.util.map
import ir.taravaz.core.data.model.BannerDto
import ir.taravaz.core.data.model.mapToBanners
import ir.taravaz.core.data.source.BannerRemoteDataSource
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.usecase.BannerRepository

class BannerRepositoryImpl(
    private val remoteDataSource: BannerRemoteDataSource,
) : BannerRepository {
    override suspend fun getBanners(): Result<List<Banner>, DataError.Network> =
        remoteDataSource.getBanners().map(List<BannerDto>::mapToBanners)
}
