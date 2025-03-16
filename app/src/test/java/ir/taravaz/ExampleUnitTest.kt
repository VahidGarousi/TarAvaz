package ir.taravaz

import io.kotest.core.spec.style.AnnotationSpec
import org.junit.jupiter.api.Assertions

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : AnnotationSpec() {
    @Test
    fun addition_isCorrect() {
        Assertions.assertEquals(4, 2 + 2)
    }
}
