package ir.taravaz.home.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import ir.taravaz.core.domain.model.PlaylistInfo
import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.UnknownHostException

internal class GetPlaylistSectionUseCaseTest {
    private lateinit var subject: GetPlaylistSectionUseCase
    private lateinit var repository: PlaylistRepository

    @BeforeEach
    fun setUp() {
        repository = mockk(relaxed = true)
        subject = GetPlaylistSectionUseCase(
            repository = repository,
        )
    }

    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `Given repository returns valid section, When invoked, Then returns PlaylistSection with correct data`() =
        runTest {
            // Arrange
            val mockPlaylists = listOf(
                PlaylistInfo(id = "1", title = "Top Hits"),
                PlaylistInfo(id = "2", title = "Chill Vibes"),
            )
            val expectedSection = PlaylistSection(title = "Popular", infos = mockPlaylists)
            coEvery { repository.getPlaylist() } returns expectedSection

            // Act
            val result = subject.invoke()

            // Assert
            result shouldBe expectedSection
            result.title shouldBe "Popular"
            result.infos shouldHaveSize 2
            result.infos[0].id shouldBe "1"
            result.infos[0].title shouldBe "Top Hits"
            result.infos[1].id shouldBe "2"
            result.infos[1].title shouldBe "Chill Vibes"
            coVerify(exactly = 1) { repository.getPlaylist() }
        }

    @Test
    fun `Given repository returns empty playlists, When invoked, Then returns section with empty list`() =
        runTest {
            // Arrange
            val expectedSection = PlaylistSection(title = "New Releases", infos = emptyList())
            coEvery { repository.getPlaylist() } returns expectedSection

            // Act
            val result = subject.invoke()

            // Assert
            result.infos.shouldBeEmpty()
            result.title shouldBe "New Releases"
        }

    @Test
    fun `Given repository throws network error, When invoked, Then propagates exception`() =
        runTest {
            // Arrange
            coEvery { repository.getPlaylist() } throws UnknownHostException("No internet")

            // Act & Assert
            val exception = shouldThrowExactly<UnknownHostException> { subject.invoke() }
            exception.message shouldBe "No internet"
        }

    @Test
    fun `Given repository throws database error, When invoked, Then propagates exception`() =
        runTest {
            // Arrange
            coEvery { repository.getPlaylist() } throws RuntimeException("DB error")

            // Act & Assert
            val exception = shouldThrowExactly<RuntimeException> { subject.invoke() }
            exception.message shouldBe "DB error"
        }

    @Test
    fun `Given repository returns large playlist section, When invoked, Then handles it efficiently`() =
        runTest {
            // Arrange
            val largeList = List(1000) { index ->
                PlaylistInfo(id = index.toString(), title = "Playlist $index")
            }
            val expectedSection = PlaylistSection(title = "Mega List", infos = largeList)
            coEvery { repository.getPlaylist() } returns expectedSection

            // Act
            val result = subject.invoke()

            // Assert
            result.infos shouldHaveSize 1000
            result.infos.last().id shouldBe "999"
            result.infos.last().title shouldBe "Playlist 999"
        }
}
