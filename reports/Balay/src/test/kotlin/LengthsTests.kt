import hw3.lengths
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LengthsTests {

    @Test
    fun `lengths test`() {
        val lengthsReturn = lengths(listOf("1234", "56", "7"))
        val ans = 7
        assertEquals(ans, lengthsReturn)
    }

    @Test
    fun `lengths test with empty strings`() {
        val lengthsReturn = lengths(listOf("", "", ""))
        val ans = 0
        assertEquals(ans, lengthsReturn)
    }
}