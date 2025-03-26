package ir.taravaz.explore.presentation

data class ExploreState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)
