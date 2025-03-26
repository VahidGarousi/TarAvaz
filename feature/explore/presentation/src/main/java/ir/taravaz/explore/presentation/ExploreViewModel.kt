package ir.taravaz.explore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.ui.util.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ExploreViewModel : ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(ExploreState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(Constants.STOP_TIMEOUT),
            initialValue = ExploreState(),
        )
}
