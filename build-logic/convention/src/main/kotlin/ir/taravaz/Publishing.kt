package ir.taravaz


import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create


internal fun Project.configureAndroidModulePublishing() {
    extensions.configure<LibraryExtension> {
        publishing {
            singleVariant("release") {
                withSourcesJar()
                withJavadocJar()
            }
        }
    }
    extensions.create("taravazPublisher", ModuleInfoExtension::class)
}



internal fun Project.configureJvmModulePublishing() {
    extensions.create("taravazPublisher", ModuleInfoExtension::class)
}

