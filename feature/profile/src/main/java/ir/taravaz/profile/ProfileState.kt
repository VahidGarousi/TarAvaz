package ir.taravaz.profile

data class ProfileState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)
