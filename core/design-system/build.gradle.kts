plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.taravaz.android.library.compose)
    alias(libs.plugins.taravaz.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "ir.taravaz.core.design_system"
}

dependencies {
    api(platform(libs.coil.bom))
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.navigationSuite)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    api(libs.coil)
    api(libs.coil.kt.compose)
    api(libs.compose.shimmer)

    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.androidx.compose.ui.testManifest)
    testImplementation(libs.robolectric)
    testImplementation(projects.core.screenshotTesting)
}
