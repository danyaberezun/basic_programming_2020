import hw3.reverse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReverseTests {

    @Test
    fun `reverse test`() {
        val reverseReturn = reverse(listOf(1, 5, 7 , 23))
        assertEquals(listOf(23, 7, 5, 1), reverseReturn)
    }
}