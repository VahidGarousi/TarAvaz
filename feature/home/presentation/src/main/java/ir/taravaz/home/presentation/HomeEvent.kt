package ir.taravaz.home.presentation

sealed interface HomeEvent {
    data object Idle : HomeEvent
}
