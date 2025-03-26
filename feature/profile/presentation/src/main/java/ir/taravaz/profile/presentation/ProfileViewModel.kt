package ir.taravaz.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.taravaz.core.ui.util.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ProfileViewModel : ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(ProfileState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(Constants.STOP_TIMEOUT),
            initialValue = ProfileState(),
        )

    fun onAction(action: ProfileAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }
}
