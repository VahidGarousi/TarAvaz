package ir.taravaz.core.ui.component.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import ir.taravaz.core.designsystem.theme.LocalShimmer
import ir.taravaz.core.designsystem.theme.TarAvazTheme

@Composable
fun Shimmer(
    modifier: Modifier = Modifier,
    color: Color = TarAvazTheme.colors.skeletonColor,
) {
    Box(
        modifier = modifier
            .shimmer(customShimmer = LocalShimmer.current)
            .background(
                color = color,
                RoundedCornerShape(16.dp),
            ),
    )
}
