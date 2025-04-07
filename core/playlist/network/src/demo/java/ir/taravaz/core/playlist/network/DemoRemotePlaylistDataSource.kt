package ir.taravaz.core.playlist.network

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.playlist.data.dto.PlaylistDto
import ir.taravaz.core.playlist.data.dto.PlaylistInfoDto
import ir.taravaz.core.playlist.data.dto.PlaylistSectionDto
import ir.taravaz.core.playlist.data.source.RemotePlaylistDataSource
import ir.taravaz.core.track.data.dto.TrackDto

class DemoRemotePlaylistDataSource : RemotePlaylistDataSource {
    override suspend fun getPopularPlaylistSection(): Result<PlaylistSectionDto, DataError.Network> =
        Result.Success(
            PlaylistSectionDto(
                title = "پلی‌لیست‌های محبوب",
                infos = listOf(
                    PlaylistInfoDto(
                        id = "pl001",
                        title = "ترانه‌های برتر ۱۴۰۲",
                    ),
                    PlaylistInfoDto(
                        id = "pl002",
                        title = "آهنگ‌های آرام",
                    ),
                    PlaylistInfoDto(
                        id = "pl003",
                        title = "موسیقی ورزشی",
                    ),
                    PlaylistInfoDto(
                        id = "pl004",
                        title = "تمرکز و آرامش",
                    ),
                    PlaylistInfoDto(
                        id = "pl005",
                        title = "خاطره‌انگیزها",
                    ),
                ),
            ),
        )

    override suspend fun getPlaylistDetail(playlistId: String): Result<PlaylistDto, DataError.Network> =
        when (playlistId) {
            "pl001" -> Result.Success(
                PlaylistDto(
                    info = PlaylistInfoDto(id = "pl001", title = "ترانه‌های برتر ۱۴۰۲"),
                    items = listOf(
                        TrackDto(
                            id = "tr001",
                            name = "بارون",
                            releaseDate = "1402-01-15",
                            description = "ترانه‌ای از یکی از خوانندگان محبوب",
                            artist = "خواننده ایرانی",
                            imageUrl = "https://example.com/image1.jpg",
                        ),
                        TrackDto(
                            id = "tr002",
                            name = "شب‌های تهران",
                            releaseDate = "1402-02-20",
                            description = "ترانه‌ای خاطره‌انگیز",
                            artist = "خواننده دیگر",
                            imageUrl = "https://example.com/image2.jpg",
                        ),
                    ),
                ),
            )

            "pl002" -> Result.Success(
                PlaylistDto(
                    info = PlaylistInfoDto(id = "pl002", title = "آهنگ‌های آرام"),
                    items = listOf(
                        TrackDto(
                            id = "tr101",
                            name = "آهنگ آرامش بخش",
                            releaseDate = "1402-03-10",
                            description = "موسیقی برای مدیتیشن",
                            artist = "نوازنده سنتی",
                            imageUrl = "https://example.com/image3.jpg",
                        ),
                    ),
                ),
            )

            else -> Result.Failure(DataError.Network.NOT_FOUND)
        }
}
