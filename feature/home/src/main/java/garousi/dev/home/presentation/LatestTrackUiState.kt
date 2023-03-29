package garousi.dev.home.presentation

import garousi.dev.home.domain.model.Track

sealed class LatestTrackUiState {
    object Loading : LatestTrackUiState()
    data class Success(val data: List<Track>) : LatestTrackUiState()
    sealed interface Failure {
        data class Unknown(val message: String) : LatestTrackUiState()
    }
}