package garousi.dev.home.presentation

import app.cash.turbine.test
import com.google.common.truth.Truth
import garousi.dev.home.domain.use_case.GetLatestTracksUseCase
import garousi.dev.home.domain.use_case.GetLatestTractsResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private val testScope = TestScope()

    private val getLatestTracksUseCase: GetLatestTracksUseCase = mockk(relaxUnitFun = true)

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(getLatestTracksUseCase)
    }

    @Test
    fun `should transition from loading to ready state`() = testScope.runTest {
        coEvery { getLatestTracksUseCase() } returns GetLatestTractsResult.Success(listOf())
        viewModel.latestTracks.test {
            val state = awaitItem()
            Truth.assertThat(state).isEqualTo(LatestTrackUiState.Loading)
            cancelAndIgnoreRemainingEvents()
        }
    }
}