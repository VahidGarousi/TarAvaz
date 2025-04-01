package ir.taravaz.home.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.LatestTracks
import ir.taravaz.core.domain.model.Track
import ir.taravaz.home.domain.repository.TrackRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GetLatestTracksUseCaseTest {
    private lateinit var subject: GetLatestTracksUseCase
    private lateinit var trackRepository: TrackRepository

    @BeforeEach
    fun setUp() {
        trackRepository = mockk(relaxed = true)
        subject = GetLatestTracksUseCase(repository = trackRepository)
    }

    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `invoke should return Result of LatestTracks`() =
        runTest {
            val result = subject.invoke()
            result.shouldBeInstanceOf<Result<LatestTracks, DataError.Network>>()
        }

    @Test
    fun `given empty tracks, invoke should return success with empty list`() =
        runTest {
            val emptyTracks = LatestTracks(id = "", title = "", items = emptyList())
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(emptyTracks)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            result.data.items.shouldBeEmpty()
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given single track, invoke should return success with correct track`() =
        runTest {
            val singleTrack = LatestTracks(
                id = "",
                title = "",
                items = listOf(track(id = "66", imageUrl = "https://google.com/test.jpg")),
            )
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(singleTrack)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            with(result.data.items) {
                shouldHaveSize(1)
                first().id.shouldBe("66")
                first().imageUrl.shouldBe("https://google.com/test.jpg")
            }
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given multiple tracks, invoke should return all tracks in correct order`() =
        runTest {
            val multipleTracks = LatestTracks(
                id = "",
                title = "",
                items = listOf(
                    track(id = "1", imageUrl = "https://example.com/1.jpg"),
                    track(id = "2", imageUrl = "https://example.com/2.jpg"),
                    track(id = "3", imageUrl = "https://example.com/3.jpg"),
                ),
            )
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(multipleTracks)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            with(result.data.items) {
                shouldHaveSize(3)
                map { it.id } shouldBe listOf("1", "2", "3")
                map { it.imageUrl } shouldBe listOf(
                    "https://example.com/1.jpg",
                    "https://example.com/2.jpg",
                    "https://example.com/3.jpg",
                )
            }
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given repository throws exception, invoke should propagate exception`() =
        runTest {
            coEvery { trackRepository.getLatestTracks() } throws RuntimeException("Unexpected error")

            shouldThrowExactly<RuntimeException> {
                subject.invoke()
            }.message.shouldBe("Unexpected error")

            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given network error, invoke should return DataError Network`() =
        runTest {
            coEvery { trackRepository.getLatestTracks() } returns Result.Failure(DataError.Network.NO_INTERNET)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Failure<DataError.Network>>()
            result.error shouldBe DataError.Network.NO_INTERNET
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given large dataset, invoke should handle it efficiently`() =
        runTest {
            val largeList = List<Track>(size = 10000) { index ->
                track(id = index.toString(), imageUrl = "https://example.com/$index.jpg")
            }
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(
                LatestTracks(id = "", title = "", items = largeList),
            )

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            result.data.items.shouldHaveSize(10000)
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given concurrent invocations, invoke should maintain thread safety`() =
        runTest {
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(
                LatestTracks(id = "", title = "", items = emptyList()),
            )

            val results = (1..10).map { async { subject.invoke() } }.awaitAll()

            results.forEach {
                it.shouldBeInstanceOf<Result.Success<LatestTracks>>()
                it.data.items.shouldBeEmpty()
            }
            coVerify(exactly = 10) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given edge case data, invoke should handle it correctly`() =
        runTest {
            val edgeCaseTracks = LatestTracks(
                id = "edge_case",
                title = "Edge Case",
                items = listOf(
                    track(id = "", imageUrl = ""),
                    track(id = "special_chars", imageUrl = "https://example.com/!@#$%^&*.jpg"),
                ),
            )
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(edgeCaseTracks)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            with(result.data.items) {
                shouldHaveSize(2)
                get(0).run {
                    id.shouldBe("")
                    imageUrl.shouldBe("")
                }
                get(1).run {
                    id.shouldBe("special_chars")
                    imageUrl.shouldBe("https://example.com/!@#$%^&*.jpg")
                }
            }
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }

    @Test
    fun `given duplicate track IDs, invoke should return all items`() =
        runTest {
            val duplicateTracks = LatestTracks(
                id = "duplicates",
                title = "Duplicates",
                items = listOf(
                    track(id = "1", imageUrl = "first.jpg"),
                    track(id = "1", imageUrl = "second.jpg"),
                ),
            )
            coEvery { trackRepository.getLatestTracks() } returns Result.Success(duplicateTracks)

            val result = subject.invoke()

            result.shouldBeInstanceOf<Result.Success<LatestTracks>>()
            with(result.data.items) {
                shouldHaveSize(2)
                map { it.id } shouldBe listOf("1", "1")
                map { it.imageUrl } shouldBe listOf("first.jpg", "second.jpg")
            }
            coVerify(exactly = 1) { trackRepository.getLatestTracks() }
        }
}
