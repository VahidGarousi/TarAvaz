package ir.taravaz.home.data

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.Track
import ir.taravaz.home.data.api.RemoteTrackDataSource

class DemoRemoteTrackDataSource : RemoteTrackDataSource {
    override suspend fun getLatestTracks(): Result<LatestTracks, DataError.Network> {
        val demoTracks = listOf(
            Track(
                id = "1",
                name = "آهنگ دمو ۱",
                releaseDate = "1704067200", // تایم‌استمپ معادل ۱۴۰۲-۱۰-۱۱
                description = "یک آهنگ نمونه برای حالت دمو.",
                artist = "هنرمند دمو",
                imageUrl = "https://placeholder.pics/svg/300",
            ),
            Track(
                id = "2",
                name = "آهنگ دمو ۲",
                releaseDate = "1707264000", // تایم‌استمپ معادل ۱۴۰۲-۱۱-۱۲
                description = "یک آهنگ نمونه دیگر برای تست.",
                artist = "هنرمند دمو ۲",
                imageUrl = "https://placeholder.pics/svg/300",
            ),
            Track(
                id = "3",
                name = "آهنگ دمو ۳",
                releaseDate = "1709856000", // تایم‌استمپ معادل ۱۴۰۲-۱۲-۲۷
                description = "آهنگ سوم برای نمایش بیشتر.",
                artist = "هنرمند دمو ۳",
                imageUrl = "https://placeholder.pics/svg/300",
            ),
            Track(
                id = "4",
                name = "آهنگ دمو ۴",
                releaseDate = "1712448000", // تایم‌استمپ معادل ۱۴۰۳-۱-۱۷
                description = "یک آهنگ دیگر برای تنوع.",
                artist = "هنرمند دمو ۴",
                imageUrl = "https://placeholder.pics/svg/300",
            ),
            Track(
                id = "5",
                name = "آهنگ دمو ۵",
                releaseDate = "1715126400", // تایم‌استمپ معادل ۱۴۰۳-۲-۱۴
                description = "پنجمین آهنگ دمو.",
                artist = "هنرمند دمو ۵",
                imageUrl = "https://placeholder.pics/svg/300",
            ),
        )
        return Result.Success(
            LatestTracks(
                id = "demo_latest",
                title = "جدیدترین آهنگ‌های دمو",
                items = demoTracks,
            ),
        )
    }

    override suspend fun getBanners(): Result<List<Banner>, DataError.Network> {
        val demoBanners = listOf(
            Banner(
                id = 1L,
                image = "https://placeholder.pics/svg/300",
                linkType = 0L, // شناسه محصول
                linkValue = "12345", // شناسه یک محصول نمونه
            ),
            Banner(
                id = 2L,
                image = "https://placeholder.pics/svg/300",
                linkType = 1L, // آدرس URL
                linkValue = "https://example.com/banner1",
            ),
            Banner(
                id = 3L,
                image = "https://placeholder.pics/svg/300",
                linkType = 2L, // شناسه مرتب‌سازی
                linkValue = "popularity", // نمونه‌ای از یک نوع مرتب‌سازی
            ),
        )
        return Result.Success(demoBanners)
    }
}
