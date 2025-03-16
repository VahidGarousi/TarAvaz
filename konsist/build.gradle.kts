plugins {
    alias(libs.plugins.taravaz.android.library)
}

android {
    namespace = "ir.vahid.konsist"
}

dependencies {
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.konsist)
}
