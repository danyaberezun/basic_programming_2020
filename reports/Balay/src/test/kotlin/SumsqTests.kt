import hw3.sumsq
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SumsqTests {

    @Test
    fun `sumsq test`() {
        val sumsqResult = sumsq(4)
        val ans = 30
        assertEquals(ans, sumsqResult)
    }

    @Test
    fun `sumsq test with zero argument`() {
        val sumsqResult = sumsq(0)
        val ans = 0
        assertEquals(ans, sumsqResult)
    }
}