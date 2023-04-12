package garousi.dev.taravaz.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import garousi.dev.design_system.debugPlaceholder
import garousi.dev.design_system.theme.TarAvazTheme
import garousi.dev.home.R
import garousi.dev.taravaz.home.domain.model.Artist
import garousi.dev.taravaz.home.domain.model.Track
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Track(
    track: Track,
    onClick: (Track) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(160.dp)
            .padding(end = 12.dp)
    ) {
        Card(
            onClick = { onClick(track) },
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.DarkGray
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            AsyncImage(
                model = track.cover,
                contentDescription = track.cover,
                placeholder = debugPlaceholder(R.drawable.gole_maryam),
                modifier = Modifier.size(115.dp)
            )
        }
        Text(
            text = track.name,
            color = Color(0xDEFFFFFF),
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = track.artist.name,
            color = Color(0x99FFFFFF),
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Composable
@Preview
fun TrackPreview() {
    val rezaBahram = Artist(
        id = UUID.randomUUID().toString(),
        name = "رضا بهرام"
    )
    val track = Track(
        id = UUID.randomUUID().toString(),
        name = "گل مریم",
        duration = 256000,
        releaseDate = 256000,
        artist = rezaBahram,
        cover = "http://tabamusic.com/wp-content/uploads/2020/11/Reza-Bahram-Gole-Maryam.jpg"
    )
    TarAvazTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Track(track = track, onClick = {})
        }
    }
}