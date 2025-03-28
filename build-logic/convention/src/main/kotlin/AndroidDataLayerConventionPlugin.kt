import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDataLayerConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        dependencies {
            add("implementation", project(":core:domain"))
        }
    }
}
