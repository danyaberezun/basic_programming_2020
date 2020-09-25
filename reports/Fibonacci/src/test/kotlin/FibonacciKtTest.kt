import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FibonacciKtTest {

    @Test
    fun `test by 0 for fibonacci`() {
        assertEquals(0, fibonacci(0))
    }

    @Test
    fun `test by 1 for fibonacci`() {
        assertEquals(1, fibonacci(1))
    }

    @Test
    fun `test by 2 for fibonacci`() {
        assertEquals(1, fibonacci(2))
    }

    @Test
    fun `test by 5 for fibonacci`() {
        assertEquals(5, fibonacci(5))
    }

    @Test
    fun `test by 10 for fibonacci`() {
        assertEquals(55, fibonacci(10))
    }
}