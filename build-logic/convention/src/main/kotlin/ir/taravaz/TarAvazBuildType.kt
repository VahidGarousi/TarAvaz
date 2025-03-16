package ir.taravaz

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class TarAvazBuildType(val versionNameSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
