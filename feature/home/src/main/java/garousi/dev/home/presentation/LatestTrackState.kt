package garousi.dev.home.presentation

import garousi.dev.home.domain.model.Track

sealed interface LatestTrackState {
    object Loading : LatestTrackState
    data class Success(val data: List<Track>) : LatestTrackState
    sealed interface Failure {
        data class Unknown(val message: String) : LatestTrackState
    }
}