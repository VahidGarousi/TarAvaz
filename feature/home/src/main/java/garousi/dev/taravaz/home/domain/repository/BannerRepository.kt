package garousi.dev.taravaz.home.domain.repository

import garousi.dev.taravaz.home.domain.model.Banner

interface BannerRepository {
    suspend fun getBanners(): Result<List<Banner>>
}