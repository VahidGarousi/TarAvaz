package ir.taravaz.home.domain

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.home.domain.repository.TrackRepository

class GetBannersUseCase(
    private val repository: TrackRepository,
) {
    suspend operator fun invoke(): Result<List<Banner>, DataError.Network> {
        return repository.getBanners()
    }
}
