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
check(JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
    """
    TarAvaz requires JDK 17+ but it is currently using JDK ${JavaVersion.current()}.
    Java Home: [${System.getProperty("java.home")}]
    https://developer.android.com/build/jdks#jdk-config-in-studio
    """.trimIndent()
}
include(":konsist")
include(":app")
include(
    ":core:domain",
    ":core:screenshot-testing",
    ":core:design-system",
    ":core:ui",
    ":core:data",
    ":core:common",
    ":core:network",
)
include(":feature:player:data", ":feature:player:presentation", ":feature:player:domain")
include(":feature:home")
include(":feature:playlist")
include(":feature:explore")
include(":feature:profile")
include(":core:track:domain")
include(":core:track:data")
include(":core:track:di")
include(":core:track:presentation")
include(":core:track:network")
include(":core:playlist:domain")
include(":core:playlist:data")
include(":core:playlist:di")
include(":core:playlist:presentation")
include(":core:playlist:network")
include(":feature:track")
