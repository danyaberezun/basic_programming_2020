import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Fibonacci {
    @Test
    fun `normal test`() {
        Assertions.assertEquals(createSequence(10), listOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55))
    }

    @Test
    fun `null test`() {
        Assertions.assertEquals(createSequence(null), null)
    }
}