import hw3.filter
import hw3.filterR
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FilterRTests {

    @Test
    fun `filterR test`() {
        val filterReturn = filterR(listOf<Int>(1, 3, 5, 6, 9, 8)) {item -> item % 2 == 0}
        val ans = listOf(8, 6)
        assertEquals(ans, filterReturn)
    }
}