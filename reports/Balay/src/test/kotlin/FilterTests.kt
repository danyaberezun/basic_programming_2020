import hw3.filter
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FilterTests {

    @Test
    fun `filter test`() {
        val filterReturn = filter(listOf<Int>(1, 3, 5, 6, 9, 8)) {item -> item % 2 == 0}
        val ans = listOf(6, 8)
        assertEquals(ans, filterReturn)
    }
}