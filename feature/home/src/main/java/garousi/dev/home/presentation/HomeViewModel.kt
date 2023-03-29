package garousi.dev.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import garousi.dev.home.domain.use_case.GetLatestTracksUseCase
import garousi.dev.home.domain.use_case.GetLatestTractsResult
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLatestTracksUseCase: GetLatestTracksUseCase
) : ViewModel() {

    private val _latestTracks: MutableStateFlow<LatestTrackUiState> = MutableStateFlow(LatestTrackUiState.Loading)
    val latestTracks = _latestTracks.asStateFlow()

    private fun getLatestTracks() {
        viewModelScope.launch {
            when (val result = getLatestTracksUseCase()) {
                is GetLatestTractsResult.Success -> {
                    _latestTracks.emit(LatestTrackUiState.Success(result.list))
                }
                is GetLatestTractsResult.Failure.Unknown -> {
                    _latestTracks.emit(LatestTrackUiState.Failure.Unknown(result.message))
                }
            }
        }
    }

    init {
        getLatestTracks()
    }
}