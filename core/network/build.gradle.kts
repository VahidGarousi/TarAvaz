plugins {
    alias(libs.plugins.taravaz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "ir.taravaz.core.network"
}

dependencies {
    api(libs.kotlinx.datetime)
    api(projects.core.common)

    implementation(platform(libs.coil.bom))
    implementation(libs.bundles.ktor)
    implementation(libs.coil)
    implementation(libs.coil.kt.network)
    implementation(libs.coil.kt.svg)
    implementation(libs.coil.network.ktor3)
    implementation(libs.koin.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    testImplementation(libs.kotlinx.coroutines.test)
}
