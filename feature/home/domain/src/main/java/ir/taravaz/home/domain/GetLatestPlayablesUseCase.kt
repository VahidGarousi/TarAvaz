package ir.taravaz.home.domain

import ir.taravaz.core.domain.model.Playables
import ir.taravaz.home.domain.repository.TrackRepository

class GetLatestPlayablesUseCase(
    private val repository: TrackRepository,
) {
    suspend operator fun invoke(): Playables {
        return repository.getLatestPlayables()
    }
}
