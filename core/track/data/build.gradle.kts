plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.feature.data)
}


android {
    namespace = "ir.taravaz.core.track.data"
}

dependencies {
    implementation(projects.core.track.domain)
}
