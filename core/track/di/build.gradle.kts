plugins {
    alias(libs.plugins.taravaz.android.library)
}

android {
    namespace = "ir.taravaz.core.track.di"
}


dependencies {
    api(projects.core.track.data)
    api(projects.core.track.domain)
    api(projects.core.track.network)
    api(projects.core.track.presentation)
}
