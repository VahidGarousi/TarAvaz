plugins {
    alias(libs.plugins.taravaz.jvm.library)
    alias(libs.plugins.taravaz.android.feature.domain)
}
dependencies {
    implementation(projects.core.common)
}
