plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ir.taravaz.core.data"
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.kotlinx.serialization.json)
    implementation(projects.core.common)
    implementation(projects.core.domain)
}
