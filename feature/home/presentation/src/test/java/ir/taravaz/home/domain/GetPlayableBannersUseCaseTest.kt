package ir.taravaz.home.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import ir.taravaz.core.domain.model.Banner
import ir.taravaz.home.domain.repository.TrackRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.UnknownHostException

internal class GetPlayableBannersUseCaseTest {
    private lateinit var subject: GetBannersUseCase
    private lateinit var trackRepository: TrackRepository

    @BeforeEach
    fun setUp() {
        trackRepository = mockk(relaxed = true)
        subject = GetBannersUseCase(repository = trackRepository)
    }

    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `Given use case is initialized, When invoked, Then calls repository exactly once`() =
        runTest {
            coEvery { trackRepository.getBanners() } returns emptyList()

            subject.invoke()

            coVerify(exactly = 1) { trackRepository.getBanners() }
        }

    @Test
    fun `Given repository returns empty list, When invoked, Then returns empty list`() =
        runTest {
            coEvery { trackRepository.getBanners() } returns emptyList()

            val result = subject.invoke()

            result.shouldBeEmpty()
        }

    @Test
    fun `Given repository returns single banner, When invoked, Then returns single banner`() =
        runTest {
            val expectedBanner = Banner(
                imageUrl = "url1",
            )
            coEvery { trackRepository.getBanners() } returns listOf(expectedBanner)

            val result = subject.invoke()

            result.shouldHaveSize(1)
            result.first() shouldBe expectedBanner
        }

    @Test
    fun `Given repository returns multiple banners, When invoked, Then returns all banners in order`() =
        runTest {
            val expectedBanners = listOf(
                Banner(imageUrl = "url1"),
                Banner(imageUrl = "url2"),
                Banner(imageUrl = "url3"),
            )
            coEvery { trackRepository.getBanners() } returns expectedBanners

            val result = subject.invoke()

            result.shouldHaveSize(3)
            result shouldBe expectedBanners
        }

    @Test
    fun `Given repository throws runtime exception, When invoked, Then propagates exception`() =
        runTest {
            val errorMessage = "Database error"
            coEvery { trackRepository.getBanners() } throws RuntimeException(errorMessage)

            val exception = shouldThrowExactly<RuntimeException> { subject.invoke() }

            exception.message shouldBe errorMessage
        }

    @Test
    fun `Given network connectivity issues, When invoked, Then throws network exception`() =
        runTest {
            coEvery { trackRepository.getBanners() } throws UnknownHostException("No internet")

            val exception = shouldThrowExactly<UnknownHostException> { subject.invoke() }

            exception.message shouldBe "No internet"
        }

    @Test
    fun `Given repository returns large number of banners, When invoked, Then handles efficiently`() =
        runTest {
            val largeBannerList = List(1000) { index ->
                Banner(imageUrl = "url$index")
            }
            coEvery { trackRepository.getBanners() } returns largeBannerList

            val result = subject.invoke()

            result.shouldHaveSize(1000)
            result.last().imageUrl shouldBe "url999"
        }

    @Test
    fun `Given repository returns duplicate banners, When invoked, Then returns all duplicates`() =
        runTest {
            val duplicateBanner = Banner(imageUrl = "url1")
            val bannersWithDuplicates = listOf(duplicateBanner, duplicateBanner)
            coEvery { trackRepository.getBanners() } returns bannersWithDuplicates

            val result = subject.invoke()

            result.shouldHaveSize(2)
            result[0] shouldBe duplicateBanner
            result[1] shouldBe duplicateBanner
        }
}
