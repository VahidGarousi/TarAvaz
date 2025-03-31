package ir.taravaz.home.domain

import ir.taravaz.core.common.util.NetworkError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.home.domain.repository.TrackRepository

class GetLatestTracksUseCase(
    private val repository: TrackRepository,
) {
    suspend operator fun invoke(): Result<LatestTracks, NetworkError> {
        return repository.getLatestTracks()
    }
}
