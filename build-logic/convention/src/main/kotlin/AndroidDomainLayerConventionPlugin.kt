import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidDomainLayerConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.run {
        apply("trader.android.library")
        dependencies {
            add("implementation", project(":core:domain"))
        }
    }
}
