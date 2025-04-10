package ir.taravaz.feature.track

import ir.taravaz.core.track.presentation.model.TrackUi
import ir.taravaz.core.ui.component.LoadableData

data class TrackState(
    val trackUi: LoadableData<TrackUi> = LoadableData.Initial,
)
