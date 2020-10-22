package foo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class mainTest {
    @Test
    fun `positive n bigger than 1`() {
        assertEquals(55, fib(10))
    }
    @Test
    fun `n = 1`() {
        assertEquals(1, fib(1))
    }
    @Test
    fun `n = 0`() {
        assertEquals(0, fib(0))
    }
    @Test
    fun `even negative n`() {
        assertEquals(-3, fib(-4))
    }
    @Test
    fun `odd negative n`() {
        assertEquals(5, fib(-5))
    }
}