package garousi.dev.taravaz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TarAvazApp(
    windowSizeClass: WindowSizeClass,
    appState: TarAvazAppState = rememberTarAvazState(
        navController = rememberNavController(),
        coroutineScope = rememberCoroutineScope(),
        windowSizeClass = windowSizeClass
    )
) {
    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        contentColor = MaterialTheme.colorScheme.onBackground,
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                TarAvazBottomBar()
            }
        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            Column(Modifier.fillMaxSize()) {
                TarAvazNavHost(appState.navController)
            }
        }
    }
}

@Composable
fun TarAvazNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = "main_screen"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("main_screen") {
            Box(
                modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF00022E)))
        }
    }
}

@Composable
fun TarAvazBottomBar() {

}
