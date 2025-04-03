package ir.taravaz.home

sealed interface HomeEvent {
    data object Idle : HomeEvent
}
