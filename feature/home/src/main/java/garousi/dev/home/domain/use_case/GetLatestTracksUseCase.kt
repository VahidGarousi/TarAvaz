package garousi.dev.home.domain.use_case

import garousi.dev.home.domain.repository.TrackRepository
import javax.inject.Inject

class GetLatestTracksUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    suspend operator fun invoke(): GetLatestTractsResult {
        return repository.getLatestTracks().fold(
            onSuccess = {
                GetLatestTractsResult.Success(it)
            },
            onFailure = {
                GetLatestTractsResult.Failure.Unknown(it.localizedMessage.orEmpty())
            }
        )
    }
}


