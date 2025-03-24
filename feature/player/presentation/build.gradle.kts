plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.feature.presentation)
}

android {
    namespace = "ir.taravaz.player.presentation"
}

dependencies {
    implementation(projects.feature.player.domain)
}
