package garousi.dev.taravaz.home.presentation.latest_tracks

import garousi.dev.taravaz.home.domain.model.Track

sealed class LatestTrackUiState {
    object Loading : LatestTrackUiState()
    data class Success(val data: List<Track>) : LatestTrackUiState()
    sealed class Failure : LatestTrackUiState() {
        data class Unknown(val message: String) : LatestTrackUiState()
    }
}