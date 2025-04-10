plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.feature.presentation)
}

android {
    namespace = "ir.taravaz.feature.track"
}

dependencies {
    implementation(projects.core.track.presentation)
}
