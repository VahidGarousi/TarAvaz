import ir.taravaz.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDomainLayerConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        dependencies {
            add("implementation", project(":core:domain"))
            add("implementation", project(":core:common"))
            add("implementation", platform(libs.findLibrary("koin-bom").get()))
            add("implementation", libs.findLibrary("koin-core").get())
        }
    }
}
