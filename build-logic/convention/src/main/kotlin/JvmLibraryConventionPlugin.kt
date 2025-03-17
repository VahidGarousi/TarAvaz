import ir.taravaz.configureKotlinJvm
import ir.taravaz.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
            dependencies {
                "testImplementation"(libs.findLibrary("kotlin.test").get())
                "testImplementation"(libs.findLibrary("mockk").get())
                "implementation"(libs.findLibrary("kotlinx-coroutines-core").get())
                "testImplementation"(libs.findLibrary("kotlinx-coroutines-test").get())
                "testImplementation"(libs.findLibrary("truth").get())
                "testImplementation"(libs.findLibrary("turbine").get())
            }
        }
    }
}
