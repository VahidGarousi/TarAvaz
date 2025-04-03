plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.feature.presentation)
}

android {
    namespace = "ir.taravaz.home"
}

dependencies {
    implementation(projects.core.track.presentation)
    implementation(projects.core.playlist.presentation)
}
