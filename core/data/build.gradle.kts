plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ir.taravaz.core.data"
}

dependencies {
    api(projects.core.common)
    api(projects.core.domain)

    implementation(libs.bundles.ktor)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
}
