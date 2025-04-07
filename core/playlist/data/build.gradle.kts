plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.feature.data)
}


android {
    namespace = "ir.taravaz.core.playlist.data"
}

dependencies {
    implementation(projects.core.playlist.domain)
    implementation(projects.core.track.data)
    implementation(projects.core.track.domain)
}
