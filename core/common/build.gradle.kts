plugins {
    alias(libs.plugins.taravaz.jvm.library)
}
dependencies {
    api(platform(libs.koin.bom))
    api(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}
