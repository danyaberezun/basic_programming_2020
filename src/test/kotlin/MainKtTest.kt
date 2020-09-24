import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun fibonacci() {
        assertEquals(fibonacci(0), 1, "fib(0) = 1")
        assertEquals(fibonacci(1), 1, "fib(1) = 1")
        assertEquals(fibonacci(2), 2, "fib(2) = 2")
        assertEquals(fibonacci(4), 5, "fib(4) = 5")
        assertEquals(fibonacci(30), 1346269, "fib(30) = 1346269")
    }
}