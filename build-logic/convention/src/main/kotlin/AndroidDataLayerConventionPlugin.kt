import ir.taravaz.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidDataLayerConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
        dependencies {
            add("implementation", project(":core:domain"))
            add("implementation", project(":core:common"))
            add("implementation", project(":core:data"))
            add("implementation", libs.findBundle("ktor").get())
            "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
        }
    }
}
