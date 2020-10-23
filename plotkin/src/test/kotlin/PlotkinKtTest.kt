import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PlotkinKtTest {
    companion object {
        val moveProgram = listOf(Zero(0, 4, 1), Decrement(0), Increment(1), Zero(0, 4, 1), Stop)

    }

    @Test
    fun charToVar() {
        assertEquals(2, charToVar('z'))
    }

    @Test
    fun parseProgram() {
        assertEquals(
            listOf(Decrement(0), Increment(2), Stop, Zero(1, 31, 9)),
            parseProgram(listOf("dec x", "inc z", "stop", "zero y 32 else 10"))
        )
    }

    @Test
    fun `union with empty`() {
        assertEquals(Range(5, 7), union(Range(5, 7), Range(9, 2)))
    }

    @Test
    fun `union of disjoint`() {
        assertEquals(Range(2, 6), union(Range(2, 2), Range(6, 6)))
    }

    @Test
    fun `union of intersecting`() {
        assertEquals(Range(4, 10), union(Range(4, 8), Range(6, 10)))
    }

    @Test
    fun `execute move`() {
        assertEquals(7, execute(moveProgram, 7))
    }

    @Test
    fun `range increment`() {
        assertEquals(Range(1, 5), Range(0, 4).increment())
    }

    @Test
    fun `range decrement`() {
        assertEquals(Range(2, 4), Range(3, 5).decrement())
    }

    @Test
    fun `decrement range starting with zero`() {
        assertEquals(Range(0, 5), Range(0, 6).decrement())
    }

    @Test
    fun update() {
        val varRanges = VarRanges(Range(1, 2), Range(1, 2), Range(0, 1))
        val otherVarRanges = VarRanges(Range(1, 1), Range(0, 3), Range(1, 2))
        assertTrue(varRanges.update(otherVarRanges))
        assertEquals(varRanges, VarRanges(Range(1, 2), Range(0, 3), Range(0, 2)))
    }

    @Test
    fun `ineffective update`() {
        val varRanges = VarRanges(Range(1, 2), Range(2, 5), Range(0, 0))
        val otherVarRanges = VarRanges(Range(5, 4), Range(2, 3), Range(0, 0))
        assertFalse(varRanges.update(otherVarRanges))
        assertEquals(varRanges, VarRanges(Range(1, 2), Range(2, 5), Range(0, 0)))
    }

    @Test
    fun getResultRange() {
        val program = listOf(Stop, Increment(0))
        assertEquals(
            Range(1, 3), getResultRange(
                program, listOf(
                    VarRanges(Range(0, 0), Range(1, 1), Range(0, 0)),
                    VarRanges(Range(0, 0), Range(0, 4), Range(0, 0)),
                    VarRanges(Range(0, 0), Range(3, 3), Range(0, 0)),
                )
            )
        )
    }
    @Test
    fun `empty result range`() {
        assertTrue(getResultRange(listOf(), listOf(VarRanges(Range(0, -1), Range(0, -1), Range(0, -1)))).isEmpty())
    }

}