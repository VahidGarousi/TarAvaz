plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.feature.data)
}

android {
    namespace = "ir.taravaz.home.data"
}

dependencies {
    implementation(projects.feature.home.domain)
}
