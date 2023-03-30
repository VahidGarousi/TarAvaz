plugins {
    id("taravaz.android.library")
    id("taravaz.android.library.compose")
    id("taravaz.android.hilt")
}

android {
    namespace = "garousi.dev.taravaz.core.testing"
}

dependencies {
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.testing)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)
    api(libs.androidx.test.ext.truth)
    api(libs.mockk.core)
    api(libs.mockk.android)
    debugApi(libs.androidx.compose.ui.testManifest)
}