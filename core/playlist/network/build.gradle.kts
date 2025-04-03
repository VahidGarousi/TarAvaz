plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "ir.taravaz.core.playlist.network"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.core.playlist.data)
    implementation(projects.core.playlist.domain)
    implementation(projects.core.track.data)
}
