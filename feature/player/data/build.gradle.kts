plugins {
    alias(libs.plugins.taravaz.android.library)
}

android {
    namespace = "ir.taravaz.player.data"
}

dependencies {
    implementation(libs.androidx.media3.common)
    // For media playback using ExoPlayer
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.exoplayer.dash)
    // For exposing and controlling media sessions
    implementation(libs.androidx.media3.session)
    implementation(libs.androidx.media3.ui)
    implementation(projects.feature.player.domain)
}
