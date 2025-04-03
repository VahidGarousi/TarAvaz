package ir.taravaz.core.domain.usecase

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner

interface BannerRepository {
    suspend fun getBanners(): Result<List<Banner>, DataError.Network>
}
