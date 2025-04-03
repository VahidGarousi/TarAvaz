package ir.taravaz.core.network

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.data.model.BannerDto
import ir.taravaz.core.data.source.BannerRemoteDataSource

private const val IMAGE_URL = "file:///android_asset/banner"

class DemoRemoteBannerDataSource : BannerRemoteDataSource {
    override suspend fun getBanners(): Result<List<BannerDto>, DataError.Network> {
        val banners = listOf(
            // Type 0 banner (product page) - product ID 123
            BannerDto(
                id = 1,
                image = IMAGE_URL + "1.png",
                linkType = 0,
                linkValue = "123",
            ),
            // Type 1 banner (external URL) - URL https://example.com/special-offer
            BannerDto(
                id = 2,
                image = IMAGE_URL + "2.png",
                linkType = 1,
                linkValue = "https://example.com/special-offer",
            ),
            // Type 2 banner (sorting) - most viewed sorting (1)
            BannerDto(
                id = 3,
                image = IMAGE_URL + "3.png",
                linkType = 2,
                linkValue = "1",
            ),
            // Type 0 banner (product page) - product ID 456
            BannerDto(
                id = 4,
                image = IMAGE_URL + "2.png",
                linkType = 0,
                linkValue = "456",
            ),
            // Type 2 banner (sorting) - newest sorting (0)
            BannerDto(
                id = 5,
                image = IMAGE_URL + "1.png",
                linkType = 2,
                linkValue = "0",
            ),
        )
        return Result.Success(banners)
    }
}
