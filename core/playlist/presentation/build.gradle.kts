plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.feature.presentation)
}

android {
    namespace = "ir.taravaz.core.track.presentation"
}

dependencies {
    api(projects.core.track.domain)
    api(projects.core.playlist.domain)
    implementation(projects.core.track.presentation)
}
