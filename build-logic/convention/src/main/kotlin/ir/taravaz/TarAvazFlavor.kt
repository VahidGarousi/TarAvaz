package ir.taravaz


import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

enum class FlavorDimension {
    MODE
}

// The content for the app can either come from local static data which is useful for demo
// purposes, or from a production backend server which supplies up-to-date, real content.
// These two product flavors reflect this behaviour.
enum class TarAvazFlavor(
    val dimension: FlavorDimension,
    val applicationIdSuffix: String? = null,
    val versionName: String,
    val versionCode: Int
) {
    DEVELOP(
        dimension = FlavorDimension.MODE,
        applicationIdSuffix = ".develop",
        versionCode = 1,
        versionName = "1.0.0"
    ),
    DEMO(
        dimension = FlavorDimension.MODE,
        applicationIdSuffix = ".demo",
        versionCode = 1,
        versionName = "1.0.0"
    )
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: TarAvazFlavor) -> Unit = {},
) {
    commonExtension.apply {
        FlavorDimension.values().forEach { flavorDimension ->
            flavorDimensions += flavorDimension.name
        }

        productFlavors {
            TarAvazFlavor.values().forEach { taravazFlavor ->
                create(taravazFlavor.name.lowercase()) {
                    dimension = taravazFlavor.dimension.name
                    flavorConfigurationBlock(this, taravazFlavor)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (taravazFlavor.applicationIdSuffix != null) {
                            applicationIdSuffix = taravazFlavor.applicationIdSuffix
                        }
                        versionCode = taravazFlavor.versionCode
                        versionName = taravazFlavor.versionName
                    }
                }
            }
        }
    }
}
