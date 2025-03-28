pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.myket.ir")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.myket.ir")
    }
}

rootProject.name = "TarAvaz"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":konsist")
include(":app")
include(":core:domain", ":core:screenshot-testing", ":core:design-system", ":core:ui")
include(":feature:player:data", ":feature:player:presentation", ":feature:player:domain")
include(":feature:home:presentation", ":feature:home:domain", ":feature:home:data")
include(":feature:playlist:presentation")
include(":feature:explore:presentation")
include(":feature:profile:presentation")

check(JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
    """
    TarAvaz requires JDK 17+ but it is currently using JDK ${JavaVersion.current()}.
    Java Home: [${System.getProperty("java.home")}]
    https://developer.android.com/build/jdks#jdk-config-in-studio
    """.trimIndent()
}
