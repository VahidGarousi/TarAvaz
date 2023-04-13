package garousi.dev.taravaz.feature.track


import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import garousi.dev.taravaz.core.design_system.component.TarAvazBackground
import garousi.dev.taravaz.core.design_system.component.TarAvazGradientBackground
import garousi.dev.taravaz.core.design_system.theme.TarAvazIcons
import garousi.dev.taravaz.core.design_system.theme.TarAvazTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackToolbar(
    navigateUp: () -> Unit, modifier: Modifier = Modifier
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Ltr
    ) {
        CenterAlignedTopAppBar(title = {
            Text(text = stringResource(R.string.player))
        }, actions = {
            IconButton(
                onClick = navigateUp
            ) {
                Icon(
                    imageVector = TarAvazIcons.ArrowBack, contentDescription = null
                )
            }
        }, modifier = modifier, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
        )
    }
}


@Composable
@Preview
private fun TrackToolbarPreview() {
    TarAvazTheme {
        TarAvazBackground(modifier = Modifier.height(200.dp)) {
            TarAvazGradientBackground {
                TrackToolbar(
                    navigateUp = {}
                )
            }
        }
    }
}