package garousi.dev.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import garousi.dev.home.TrackCard

@Composable
fun LatestTracks(
    state: LatestTrackState,
    modifier: Modifier = Modifier
) {
  Column(
      modifier = modifier
  ) {
      Box(
          modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp)
      ) {
          Text(text = "Latest songs...", modifier = Modifier.align(Alignment.CenterStart))
          TextButton(onClick = { }, modifier = Modifier.align(Alignment.CenterEnd)) {
              Text(text = "All")
          }
      }
      when (state) {
          LatestTrackState.Loading -> Unit
          is LatestTrackState.Success -> {
              LazyRow(
                  contentPadding = PaddingValues(8.dp)
              ) {
                  items(state.data) { track ->
                      TrackCard(track = track, onClick = {})
                  }
              }
          }
          is LatestTrackState.Failure.Unknown -> Unit
      }
  }
}