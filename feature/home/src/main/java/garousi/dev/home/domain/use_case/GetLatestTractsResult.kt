package garousi.dev.home.domain.use_case

import garousi.dev.home.domain.model.Track

sealed interface GetLatestTractsResult {
    data class Success(val list: List<Track>) : GetLatestTractsResult
    sealed interface Failure {
        data class Unknown(val message : String) : GetLatestTractsResult
    }
}