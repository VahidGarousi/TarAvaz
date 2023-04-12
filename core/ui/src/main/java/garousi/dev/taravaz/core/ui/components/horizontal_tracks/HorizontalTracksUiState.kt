package garousi.dev.taravaz.core.ui.components.horizontal_tracks

import garousi.dev.taravaz.core.model.Track

sealed class HorizontalTracksUiState {
    object Loading : HorizontalTracksUiState()
    data class Success(val data: List<Track>) : HorizontalTracksUiState()
    sealed class Failure : HorizontalTracksUiState() {
        data class Unknown(val message: String) : HorizontalTracksUiState()
    }
}