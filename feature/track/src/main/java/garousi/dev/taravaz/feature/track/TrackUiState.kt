package garousi.dev.taravaz.feature.track

sealed interface TrackUiState {
    object Loading : TrackUiState
    data class Track(val track: garousi.dev.taravaz.core.model.Track) : TrackUiState
}