@file:Suppress("LongParameterList")

package ir.taravaz.home.domain

import ir.taravaz.core.domain.model.Track

fun track(
    id: String = "123",
    name: String = "شهرزاد",
    releaseDate: String = "1743321015",
    description: String = "این آهنگ قشنگ",
    artist: String = "رضا بهرام",
    imageUrl: String = "https://google.com/400",
) = Track(
    id = id,
    name = name,
    releaseDate = releaseDate,
    description = description,
    artist = artist,
    imageUrl = imageUrl,
)
