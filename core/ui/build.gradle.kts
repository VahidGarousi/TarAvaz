plugins {
    id("taravaz.android.library")
    id("taravaz.android.library.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "garousi.dev.taravaz.core.ui"
}

dependencies {
    implementation(projects.core.model)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.metrics)
    api(libs.androidx.tracing.ktx)
    debugApi(libs.androidx.compose.ui.tooling)
    implementation(projects.core.designSystem)
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    androidTestImplementation(projects.core.testing)
}