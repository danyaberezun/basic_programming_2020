import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FibonacciKtTest {

    @Test
    fun fib0() {
        Assertions.assertEquals(fib(0), 0)
    }

    @Test
    fun fib20() {
        Assertions.assertEquals(fib(20), 6765)
    }

    @Test
    fun fib30() {
        Assertions.assertEquals(fib(30), 832040)
    }


}