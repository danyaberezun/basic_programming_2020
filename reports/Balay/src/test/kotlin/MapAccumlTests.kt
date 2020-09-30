import hw3.mapAccumL
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MapAccumlTests {

    @Test
    fun `mapAccumL example1`() {
        val returnMapAccuml = listOf(9, 6, 3).mapAccumL(5) {x, y -> Pair(x, x * y)}
        val ans = Pair(5, listOf(45, 30, 15))
        assertEquals(ans, returnMapAccuml)
    }

    @Test
    fun `mapAccumL example2`() {
        val returnMapAccuml = listOf(2, 4, 8).mapAccumL(5) {x, y -> Pair(x + y, x * y)}
        val ans = Pair(19, listOf(10, 28, 88))
        assertEquals(ans, returnMapAccuml)
    }

    @Test
    fun `mapAccumL example3`() {
        val returnMapAccuml = listOf(2, 4, 8).mapAccumL(5) {x, y -> Pair(x + y, y)}
        val ans = Pair(19, listOf(2, 4, 8))
        assertEquals(ans, returnMapAccuml)
    }

    @Test
    fun `mapAccumL example4`() {
        val returnMapAccuml = listOf(2, 4, 8).mapAccumL(5) {x, y -> Pair(y, y)}
        val ans = Pair(8, listOf(2, 4, 8))
        assertEquals(ans, returnMapAccuml)
    }

    @Test
    fun `mapAccumL example5`() {
        val returnMapAccuml = listOf(2, 4, 8).mapAccumL(5) {x, y -> Pair(x, x)}
        val ans = Pair(5, listOf(5, 5, 5))
        assertEquals(ans, returnMapAccuml)
    }
}