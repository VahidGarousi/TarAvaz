package garousi.dev.taravaz.home.domain.use_case

import garousi.dev.taravaz.core.model.Track

sealed interface GetLatestTractsResult {
    data class Success(val data: List<Track>) : GetLatestTractsResult
    sealed interface Failure {
        data class Unknown(val message : String) : GetLatestTractsResult
    }
}