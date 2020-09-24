import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.lang.Exception

internal class FibonacciKtTest {
    @Test
    fun first() {
        assertEquals(0, fibonacci(0))
    }
    @Test
    fun second() {
        assertEquals(1, fibonacci(1))
    }
    @Test
    fun small() {
        assertEquals(8, fibonacci(6))
    }
    @Test
    fun large() {
        assertEquals(23416728348467685, fibonacci(80))
    }
    @Test
    fun readFile() {
        assertEquals(listOf(0, 1, 2, 3, 4, 80, 1), readFile("data/test"))
    }
    @Test(expected = InvalidInputException::class)
    fun noFile() {
        main(arrayOf())
    }
    @Test(expected = InvalidInputException::class)
    fun wrongFile() {
        main(arrayOf("???"))
    }
}