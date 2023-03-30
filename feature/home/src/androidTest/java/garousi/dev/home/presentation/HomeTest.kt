package garousi.dev.home.presentation

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import garousi.dev.home.data.di.RepositoryModule
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
class HomeTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }
}