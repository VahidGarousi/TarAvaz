package garousi.dev.taravaz.home.data.repository

import garousi.dev.taravaz.core.model.Track
import garousi.dev.taravaz.core.model.Artist

object MockTrackGenerator {
    val rezaBahram = Artist(
        id = "bb25a00c-70ac-42f9-b42c-43b11f8df90f",
        name = "رضا بهرام"
    )
    val shadmehrAghili = Artist(
        id = "b6f391ee-db09-4d9e-8b59-2349b80085d8",
        name = "شادمهر عقیلی"
    )
    val fakeTracks = arrayListOf<Track>().apply {
        add(
            Track(
                id = "2cd75006-0d1a-4718-86a6-bf10052f6e08",
                name = "گل مریم",
                duration = 256000,
                releaseDate = 256000,
                artist = rezaBahram,
                cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
            )
        )
        add(
            Track(
                id = "d7991cbb-12e5-400b-a98e-d8a0a64c8268",
                name = "قاضی",
                duration = 256000,
                releaseDate = 256000,
                artist = shadmehrAghili,
                cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
            )
        )
        add(
            Track(
                id = "2cd75006-0d1a-4718-86a6-bf10052f6e08",
                name = "گل مریم",
                duration = 256000,
                releaseDate = 256000,
                artist = rezaBahram,
                cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
            )
        )
        add(
            Track(
                id = "c05b1789-a12a-4071-bfe6-47b95dfa243f",
                name = "قاضی",
                duration = 256000,
                releaseDate = 256000,
                artist = shadmehrAghili,
                cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
            )
        )

        add(
            Track(
                id = "2cd75006-0d1a-4718-86a6-bf10052f6e08",
                name = "گل مریم",
                duration = 256000,
                releaseDate = 256000,
                artist = rezaBahram,
                cover = "https://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
            )
        )
        add(
            Track(
                id = "ce969a80-005d-46da-8cc1-15d2d3d0a986",
                name = "قاضی",
                duration = 256000,
                releaseDate = 256000,
                artist = shadmehrAghili,
                cover = "https://www.topseda.ir/wp-content/uploads/2020/08/Shadmehr-Aghili-%E2%80%93-Ghazi.jpg"
            )
        )
    }
}