import com.android.build.gradle.LibraryExtension
import ir.taravaz.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidPresentationLayerConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
        apply(plugin = "taravaz.android.library")
        extensions.configure<LibraryExtension> {
            testOptions.animationsDisabled = true
        }
        dependencies {
            "implementation"(project(":core:design-system"))
            "implementation"(project(":core:ui"))
            "implementation"(project(":core:domain"))

            "implementation"(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
            "implementation"(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
            "implementation"(libs.findLibrary("androidx.navigation.compose").get())
            "implementation"(libs.findLibrary("androidx.tracing.ktx").get())
            "implementation"(libs.findLibrary("kotlinx.serialization.json").get())

            "testImplementation"(libs.findLibrary("androidx.navigation.testing").get())
            "androidTestImplementation"(
                libs.findLibrary("androidx.lifecycle.runtimeTesting").get(),
            )
        }
    }
}
