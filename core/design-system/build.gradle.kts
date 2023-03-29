plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "garousi.dev.design_system"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    api(composeBom)
    api("androidx.core:core-ktx:1.9.0")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    api("androidx.activity:activity-compose:1.7.0")
    api("androidx.compose.material3:material3:1.1.0-alpha06")
    api("androidx.hilt:hilt-navigation-compose:1.0.0")
    api("androidx.compose.ui:ui")
    api("androidx.compose.ui:ui-tooling-preview")
    // Jetpack Compose Integration
    api("androidx.navigation:navigation-compose:2.5.3")
    api("androidx.compose.material3:material3:1.0.1")
    api("androidx.compose.material3:material3-window-size-class:1.0.1")
    api("androidx.core:core-splashscreen:1.0.0")
    api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")
    api("io.coil-kt:coil-compose:2.3.0")

    debugApi("androidx.compose.ui:ui-tooling")
    debugApi("androidx.compose.ui:ui-test-manifest")


    testApi("junit:junit:4.13.2")
    testApi("com.google.truth:truth:1.1.3")
    testApi("app.cash.turbine:turbine:0.12.1")

    androidTestApi(composeBom)
    androidTestApi("androidx.test.ext:junit:1.1.5")
    androidTestApi("androidx.test.espresso:espresso-core:3.5.1")
    androidTestApi("androidx.compose.ui:ui-test-junit4")
}

kapt {
    correctErrorTypes = true
}
