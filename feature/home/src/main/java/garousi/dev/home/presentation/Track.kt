package garousi.dev.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import garousi.dev.home.domain.model.Track

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackCard(
    track: Track,
    onClick: (Track) -> Unit
) {
    Column {
        Card(
            onClick = { onClick(track) },
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.DarkGray
            )
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 12.dp)
            )
        }
        Text(text = track.name)
        Text(text = track.artist.name)
    }
}