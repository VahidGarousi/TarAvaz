package garousi.dev.taravaz.home.domain.use_case

import com.google.common.truth.Truth.assertThat
import garousi.dev.taravaz.home.data.repository.MockTrackGenerator
import garousi.dev.taravaz.home.domain.repository.TrackRepository
import garousi.dev.taravaz.home.presentation.FakeTrackRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetLatestTracksUseCaseTest {

    private lateinit var getLatestTracks: GetLatestTracksUseCase
    private lateinit var trackRepository: TrackRepository

    @Before
    fun setUp() {
        trackRepository = FakeTrackRepository()
        getLatestTracks = GetLatestTracksUseCase(repository = trackRepository)
    }

    @Test
    fun `Get latest tracks, returns success with latest tracks`() = runBlocking {
        val result = getLatestTracks()
        assertThat(result).isInstanceOf(GetLatestTractsResult.Success::class.java)
        (result as GetLatestTractsResult.Success).data.forEachIndexed { index, track ->
            assertThat(track).isEqualTo(MockTrackGenerator.fakeTracks[index])
        }
    }

    @Test
    fun `Get latest tracks, returns failure`() = runBlocking {
        (trackRepository as FakeTrackRepository).setShouldReturnNetworkError(true)
        val result = getLatestTracks()
        assertThat(result).isInstanceOf(GetLatestTractsResult.Failure.Unknown::class.java)
        val errorMessage = (result as GetLatestTractsResult.Failure.Unknown).message
        assertThat(errorMessage).isEqualTo("Error Occurred")
    }

    @Test
    fun `Get latest tracks, returns success with empty list`() = runBlocking {
        (trackRepository as FakeTrackRepository).setShouldReturnEmptyList(true)
        val result = getLatestTracks()
        assertThat(result).isInstanceOf(GetLatestTractsResult.Success::class.java)
        val latestTracks = (result as GetLatestTractsResult.Success).data
        assertThat(latestTracks).isEmpty()
    }
}