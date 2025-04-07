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
    api(platform(libs.coil.bom))
    api(libs.bundles.ktor)
    api(libs.coil)
    api(libs.coil.kt.network)
    api(libs.coil.kt.svg)
    api(libs.coil.network.ktor3)
    api(libs.koin.android)
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.serialization.json)
    api(libs.okhttp.logging)
    api(libs.retrofit.core)
    api(libs.retrofit.kotlin.serialization)
    implementation(projects.core.common)
    implementation(projects.core.data)

    testImplementation(libs.kotlinx.coroutines.test)
}
