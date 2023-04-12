package garousi.dev.taravaz.home.data.repository

import garousi.dev.taravaz.home.domain.model.Banner
import garousi.dev.taravaz.home.domain.repository.BannerRepository
import javax.inject.Inject

class FakeBannerRepository @Inject constructor() : BannerRepository {
    override suspend fun getBanners(): Result<List<Banner>> {
        return Result.success(MockBannerGenerator.fakeBanners)
    }
}