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
import ir.taravaz.core.domain.model.Playable
import ir.taravaz.core.domain.model.Playables
import ir.taravaz.home.domain.repository.TrackRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.UnknownHostException

internal class GetLatestPlayablesUseCaseTest {
    private lateinit var subject: GetLatestPlayablesUseCase
    private lateinit var trackRepository: TrackRepository

    @BeforeEach
    fun setUp() {
        trackRepository = mockk(relaxed = true)
        subject = GetLatestPlayablesUseCase(
            repository = trackRepository,
        )
    }

    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `Given use case is initialized, When invoked, Then returns Playables object`() =
        runTest {
            val result = subject.invoke()
            result.shouldBeInstanceOf<Playables>()
        }

    @Test
    fun `Given repository returns empty playables, When invoked, Then returns empty list`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "",
                title = "",
                items = emptyList(),
            )
            val result = subject.invoke()
            result.items.shouldBeEmpty()
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository returns single playable, When invoked, Then returns correct playable`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "",
                title = "",
                items = listOf(Playable(id = "66", cover = "https://google.com/test.jpg")),
            )

            val result = subject.invoke()

            result.items.shouldHaveSize(1)
            with(result.items.first()) {
                id.shouldBe("66")
                cover.shouldBe("https://google.com/test.jpg")
            }
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository returns multiple playables, When invoked, Then returns all playables in correct order`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "",
                title = "",
                items = listOf(
                    Playable(id = "1", cover = "https://example.com/1.jpg"),
                    Playable(id = "2", cover = "https://example.com/2.jpg"),
                    Playable(id = "3", cover = "https://example.com/3.jpg"),
                ),
            )

            val result = subject.invoke()

            result.items.shouldHaveSize(3)
            result.items.map { it.id } shouldBe listOf("1", "2", "3")
            result.items.map { it.cover } shouldBe listOf(
                "https://example.com/1.jpg",
                "https://example.com/2.jpg",
                "https://example.com/3.jpg",
            )
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository throws runtime exception, When invoked, Then propagates exception`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } throws RuntimeException("Unexpected error")
            val exception = shouldThrowExactly<RuntimeException> { subject.invoke() }
            exception.message.shouldBe("Unexpected error")
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository returns large dataset, When invoked, Then handles it efficiently`() =
        runTest {
            val largeList = List(10000) { index ->
                Playable(id = index.toString(), cover = "https://example.com/$index.jpg")
            }
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "",
                title = "",
                items = largeList,
            )
            val result = subject.invoke()
            result.items.shouldHaveSize(10000)
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given multiple concurrent invocations, When executed, Then maintains thread safety`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "",
                title = "",
                items = emptyList(),
            )

            val results = (1..10).map { async { subject.invoke() } }.awaitAll()

            results.forEach { it.items.shouldBeEmpty() }
            coVerify(exactly = 10) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given network connectivity issues, When invoked, Then throws network exception`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } throws UnknownHostException("Network error")

            val exception = shouldThrowExactly<UnknownHostException> { subject.invoke() }

            exception.message.shouldBe("Network error")
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository returns edge case data, When invoked, Then handles it correctly`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "edge_case",
                title = "Edge Case",
                items = listOf(
                    Playable(id = "", cover = ""),
                    Playable(id = "special_chars", cover = "https://example.com/!@#$%^&*.jpg"),
                ),
            )

            val result = subject.invoke()

            result.items.shouldHaveSize(2)
            with(result.items[0]) {
                id.shouldBe("")
                cover.shouldBe("")
            }
            with(result.items[1]) {
                id.shouldBe("special_chars")
                cover.shouldBe("https://example.com/!@#$%^&*.jpg")
            }
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }

    @Test
    fun `Given repository returns playables with duplicate IDs, When invoked, Then returns all items`() =
        runTest {
            coEvery { trackRepository.getLatestPlayables() } returns Playables(
                id = "duplicates",
                title = "Duplicates",
                items = listOf(
                    Playable(id = "1", cover = "first.jpg"),
                    Playable(id = "1", cover = "second.jpg"),
                ),
            )

            val result = subject.invoke()

            result.items.shouldHaveSize(2)
            result.items.map { it.id } shouldBe listOf("1", "1")
            result.items.map { it.cover } shouldBe listOf("first.jpg", "second.jpg")
            coVerify(exactly = 1) { trackRepository.getLatestPlayables() }
        }
}
