import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PlotkinKtTest {

    @Test
    fun nameToNumberX() {
        assertEquals(0, nameToNumber("x"))
    }

    @Test
    fun nameToNumberY() {
        assertEquals(1, nameToNumber("y"))
    }

    @Test
    fun nameToNumberZ() {
        assertEquals(2, nameToNumber("z"))
    }

    @Test
    fun incrementX() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(2, 0, 3), increment("x", variables))
    }

    @Test
    fun incrementY() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(1, 1, 3), increment("y", variables))
    }

    @Test
    fun incrementZ() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(1, 0, 4), increment("z", variables))
    }

    @Test
    fun decrementX() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(0, 0, 3), decrement("x", variables))
    }

    @Test
    fun decrementY() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(1, 0, 3), decrement("y", variables))
    }

    @Test
    fun decrementZ() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(listOf(1, 0, 2), decrement("z", variables))
    }

    @Test
    fun zeroX() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(2, zero(variables, "x", 1, 2))
    }

    @Test
    fun zeroY() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(1, zero(variables, "y", 1, 2))
    }

    @Test
    fun zeroZ() {
        val variables = mutableListOf<Int>(1, 0, 3)
        assertEquals(2, zero(variables, "z", 1, 2))
    }
}