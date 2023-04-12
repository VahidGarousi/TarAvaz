package garousi.dev.taravaz.home.domain.use_case

import garousi.dev.taravaz.home.domain.repository.BannerRepository
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(
    private val repository: BannerRepository
) {
    suspend operator fun invoke(): GetBannersResult {
        return repository.getBanners().fold(
            onSuccess = {
                GetBannersResult.Success(it)
            },
            onFailure = {
                GetBannersResult.Failure.Unknown(it.localizedMessage.orEmpty())
            }
        )
    }
}


