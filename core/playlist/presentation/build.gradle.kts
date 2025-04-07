plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.feature.presentation)
}

android {
    namespace = "ir.taravaz.core.playlist.presentation"
}

dependencies {
    api(projects.core.playlist.domain)
    api(projects.core.track.domain)

    implementation(projects.core.track.presentation)
}
