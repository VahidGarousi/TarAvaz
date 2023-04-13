package garousi.dev.taravaz.feature.track

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import garousi.dev.taravaz.feature.track.domain.GetTrackByIdResult
import garousi.dev.taravaz.feature.track.domain.GetTrackByIdUseCase
import garousi.dev.taravaz.feature.track.navigation.TrackArgs
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "TrackViewModel"

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getTrackById: GetTrackByIdUseCase
) : ViewModel() {
    private val trackArgs = TrackArgs(savedStateHandle)

    private val _trackUiState: MutableStateFlow<TrackUiState> = MutableStateFlow(TrackUiState.Loading)
    val trackUiState = _trackUiState.asStateFlow()


    init {
        viewModelScope.launch {
            when (val result = getTrackById(trackArgs.trackId)) {
                is GetTrackByIdResult.Error -> {
                    Log.e(TAG, "" + result.message)
                }
                is GetTrackByIdResult.Success -> {
                    _trackUiState.emit(TrackUiState.Track(result.track))
                }
            }
        }
    }
}