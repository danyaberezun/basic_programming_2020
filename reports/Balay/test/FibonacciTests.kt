import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import xd.*

internal class FibonacciTests {

    @Test
    fun `fibonacci test`() {
        val answer = 34
        val result = fibonacci(9)
        assertEquals(answer, result)
    }

    @Test
    fun `fibonacci test with argument == 2`() {
        val answer = 1
        val result = fibonacci(2)
        assertEquals(answer, result)
    }

    @Test
    fun `fibonacci test with incorrect argument`() {
        val answer = -1
        val result = fibonacci(-4)
        assertEquals(answer, result)
    }
}