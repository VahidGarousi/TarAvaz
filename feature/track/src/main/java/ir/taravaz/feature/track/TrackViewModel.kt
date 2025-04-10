package ir.taravaz.feature.track

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import ir.taravaz.core.track.presentation.TrackNavType
import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.ui.component.LoadableData
import ir.taravaz.core.ui.viewmodel.BaseViewModel
import ir.taravaz.feature.track.navigation.TrackRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlin.reflect.typeOf

class TrackViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val trackNavType: TrackNavType,
) : BaseViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(TrackState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                _state.update {
                    it.copy(
                        trackUi = LoadableData.Loaded(
                            data = savedStateHandle
                                .toRoute<TrackRoute>(
                                    typeMap = mapOf(
                                        typeOf<TrackUi>() to trackNavType,
                                    ),
                                ).trackUi,
                        ),
                    )
                }
                hasLoadedInitialData = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = TrackState(),
        )

    fun onAction(action: TrackAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }
}
