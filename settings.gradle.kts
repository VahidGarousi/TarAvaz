pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "TarAvaz"
include(":app")
include(":feature:home")
include(":core:design-system")
