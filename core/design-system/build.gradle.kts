plugins {
    id("taravaz.android.library")
    id("taravaz.android.library.compose")
}

android {
    namespace = "garousi.dev.taravaz.core.design_system"
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.core.ktx)
    androidTestImplementation(projects.core.testing)
}