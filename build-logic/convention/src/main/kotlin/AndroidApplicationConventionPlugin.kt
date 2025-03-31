import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.BaseExtension
import ir.taravaz.configureBadgingTasks
import ir.taravaz.configureKotlinAndroid
import ir.taravaz.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.dependencies


class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("taravaz.android.ktlint")
                apply("com.dropbox.dependency-guard")
                apply("taravaz.android.detekt")
                apply("taravaz.koin.android.application")
                apply("com.squareup.sort-dependencies")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = TARGET_SDK_VERSION
                testOptions.animationsDisabled = true
//                configureGradleManagedDevices(this)
            }
            extensions.configure<ApplicationAndroidComponentsExtension> {
//                configurePrintApksTask(this)
                configureBadgingTasks(extensions.getByType<BaseExtension>(), this)
            }
            dependencies {
                "implementation"(project(":core:common"))
                "implementation"(project(":core:data"))
                "implementation"(libs.findLibrary("kotlinx-coroutines-guava").get())
                "implementation"(libs.findLibrary("kotlinx-coroutines-test").get())
            }
        }
    }

}
