package ir.taravaz.home.domain

import ir.taravaz.core.domain.model.PlayableBanner
import ir.taravaz.home.domain.repository.TrackRepository

class GetPlayableBannersUseCase(
    private val repository: TrackRepository,
) {
    suspend operator fun invoke(): List<PlayableBanner> {
        return repository.getPlayableBanners()
    }
}
