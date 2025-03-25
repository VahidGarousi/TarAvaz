plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "ir.taravaz.core.ui"
}

dependencies {
    api(libs.androidx.metrics)
    api(projects.core.designSystem)

    implementation(libs.androidx.browser)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.network)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}
