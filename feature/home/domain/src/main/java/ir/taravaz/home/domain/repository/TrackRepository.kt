package ir.taravaz.home.domain.repository

import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.core.domain.model.Playables
import ir.taravaz.core.domain.model.PlaylistSection

interface TrackRepository {
    suspend fun getLatestPlayables(): Playables
    suspend fun getPlayableBanners(): List<PlayableBanner>
}
