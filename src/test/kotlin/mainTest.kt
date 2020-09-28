package kek
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
internal class mainTest {
    @Test
    fun `positive n bigger than 1`() {
        assertEquals(55, fibonacci(10))
    }
    @Test
    fun `n = 1`() {
        assertEquals(1, fibonacci(1))
    }
    @Test
    fun `n = 0`() {
        assertEquals(0, fibonacci(0))
    }
    @Test
    fun `even negative n`() {
        assertEquals(-3, fibonacci(-4))
    }
    @Test
    fun `odd negative n`() {
        assertEquals(5, fibonacci(-5))
    }
}