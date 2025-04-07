package ir.taravaz.playlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.common.constants.TarAvazAppConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class PlaylistViewModel : ViewModel() {
    private var hasLoadedInitialData = false
    private val _state = MutableStateFlow(PlaylistState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TarAvazAppConstants.STOP_TIMEOUT),
            initialValue = PlaylistState(),
        )
}
