plugins {
    alias(libs.plugins.taravaz.android.library)
}

android {
    namespace = "ir.taravaz.home.di"
}


dependencies {
    api(projects.feature.home.presentation)

    implementation(projects.feature.home.data)
    implementation(projects.feature.home.domain)
}
