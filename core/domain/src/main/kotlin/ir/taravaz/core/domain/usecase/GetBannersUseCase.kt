package ir.taravaz.core.domain.usecase

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner

class GetBannersUseCase(
    private val repository: BannerRepository,
) {
    suspend operator fun invoke(): Result<List<Banner>, DataError.Network> {
        return repository.getBanners()
    }
}
