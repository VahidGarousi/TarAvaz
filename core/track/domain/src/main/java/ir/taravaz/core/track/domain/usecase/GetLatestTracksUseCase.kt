package ir.taravaz.core.track.domain.usecase

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.track.domain.moel.LatestTracks
import ir.taravaz.core.track.domain.repository.TrackRepository

class GetLatestTracksUseCase(
    private val repository: TrackRepository
) {
    suspend operator fun invoke(): Result<LatestTracks, DataError.Network> {
        return repository.getLatestTracks()
    }
}
