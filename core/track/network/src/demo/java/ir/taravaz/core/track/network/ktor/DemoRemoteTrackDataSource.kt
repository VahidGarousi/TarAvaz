package ir.taravaz.core.track.network.ktor

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.track.data.dto.LatestTracksDto
import ir.taravaz.core.track.data.dto.TrackDto
import ir.taravaz.core.track.data.source.RemoteTrackDataSource

private const val IMAGE_URL = "file:///android_asset/artist"

class DemoRemoteTrackDataSource : RemoteTrackDataSource {
    override suspend fun getLatestTracks(): Result<LatestTracksDto, DataError.Network> {
        val demoTracks = listOf(
            TrackDto(
                id = "1",
                name = "آهنگ دمو ۱",
                releaseDate = "1704067200", // تایم‌استمپ معادل ۱۴۰۲-۱۰-۱۱
                description = "یک آهنگ نمونه برای حالت دمو.",
                artist = "هنرمند دمو",
                imageUrl = IMAGE_URL + "1.png",
            ),
            TrackDto(
                id = "2",
                name = "آهنگ دمو ۲",
                releaseDate = "1707264000", // تایم‌استمپ معادل ۱۴۰۲-۱۱-۱۲
                description = "یک آهنگ نمونه دیگر برای تست.",
                artist = "هنرمند دمو ۲",
                imageUrl = IMAGE_URL + "2.png",
            ),
            TrackDto(
                id = "3",
                name = "آهنگ دمو ۳",
                releaseDate = "1709856000", // تایم‌استمپ معادل ۱۴۰۲-۱۲-۲۷
                description = "آهنگ سوم برای نمایش بیشتر.",
                artist = "هنرمند دمو ۳",
                imageUrl = IMAGE_URL + "3.png",
            ),
            TrackDto(
                id = "4",
                name = "آهنگ دمو ۴",
                releaseDate = "1712448000", // تایم‌استمپ معادل ۱۴۰۳-۱-۱۷
                description = "یک آهنگ دیگر برای تنوع.",
                artist = "هنرمند دمو ۴",
                imageUrl = IMAGE_URL + "1.png",
            ),
            TrackDto(
                id = "5",
                name = "آهنگ دمو ۵",
                releaseDate = "1715126400", // تایم‌استمپ معادل ۱۴۰۳-۲-۱۴
                description = "پنجمین آهنگ دمو.",
                artist = "هنرمند دمو ۵",
                imageUrl = IMAGE_URL + "2.png",
            ),
        )
        return Result.Success(
            LatestTracksDto(
                id = "demo_latest",
                title = "جدیدترین ترانه ها",
                items = demoTracks,
            ),
        )
    }
}
