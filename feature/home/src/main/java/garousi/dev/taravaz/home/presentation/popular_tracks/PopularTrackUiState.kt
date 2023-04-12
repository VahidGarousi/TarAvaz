package garousi.dev.taravaz.home.presentation.popular_tracks

import garousi.dev.taravaz.home.domain.model.Track

sealed class PopularTrackUiState {
    object Loading : PopularTrackUiState()
    data class Success(val data: List<Track>) : PopularTrackUiState()
    sealed class Failure : PopularTrackUiState() {
        data class Unknown(val message: String) : PopularTrackUiState()
    }
}