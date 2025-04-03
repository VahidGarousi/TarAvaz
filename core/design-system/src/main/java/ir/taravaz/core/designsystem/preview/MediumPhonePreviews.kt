package ir.taravaz.core.designsystem.preview
import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * A custom annotation for creating previews on a medium-sized phone in both light and dark themes.
 *
 * This annotation simplifies the creation of previews that specifically target a medium-sized
 * phone (e.g., 411dp x 891dp) and allow testing in both light and dark themes. Using a single
 * annotation instead of duplicating `@Preview` parameters improves code readability and reduces
 * the chance of inconsistencies between light and dark theme previews.
 */
@Preview(
    group = "Medium Phone",
    device = "spec:width=411dp,height=891dp",
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    backgroundColor = 0xFFEAECF2,
)
@Preview(
    group = "Medium Phone",
    device = "spec:width=411dp,height=891dp",
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF1C202F,
)
annotation class MediumPhonePreviews

/**
 * A custom annotation for creating previews on a medium-sized phone in both light and dark themes.
 *
 * This annotation simplifies the creation of previews that specifically target a medium-sized
 * phone (e.g., 411dp x 891dp) and allow testing in both light and dark themes. Using a single
 * annotation instead of duplicating `@Preview` parameters improves code readability and reduces
 * the chance of inconsistencies between light and dark theme previews.
 */
@Preview(
    group = "Small Phone",
    device = "id:small_phone",
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    group = "Small Phone",
    device = "id:small_phone",
    name = "Small Phone",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class SmallPhonePreviews

@MediumPhonePreviews
@SmallPhonePreviews
annotation class ThemePreviews
