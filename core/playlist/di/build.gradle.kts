plugins {
    alias(libs.plugins.taravaz.android.library)
}

android {
    namespace = "ir.taravaz.core.playlist.di"
}


dependencies {
    api(projects.core.playlist.data)
    api(projects.core.playlist.domain)
    api(projects.core.playlist.network)
    api(projects.core.playlist.presentation)
}
