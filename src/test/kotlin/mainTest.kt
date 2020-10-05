import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class mainTest {

    @Test
    fun `sorting of empty list`() {
        assertEquals(quicksort(listOf()), listOf<Int>())
    }
    @Test
    fun `sorting one element list`() {
        assertEquals(quicksort(listOf(239)), listOf(239))
    }
    @Test
    fun `sorting list of bigger than 1 elements`() {
        assertEquals(quicksort(listOf(3, 1, 2, 1, 4, 23, 3, 0)),
            listOf(0, 1, 1, 2, 3, 3, 4, 23))
    }

    @Test
    fun reverse() {
        assertEquals(reverse(listOf("b", "a", "d", "c")),
            listOf("c", "d", "a", "b"))
    }

    @Test
    fun filterByFold() {
        assertEquals(filterByFold(listOf(1, 2, 4, 5, 36, 78532)) {it % 2 == 0},
            listOf(2, 4, 36, 78532))
    }

    @Test
    fun filterByFoldRight() {
        assertEquals(filterByFoldRight(listOf(1, 2, 4, 5, 36, 78532)) {it % 2 == 0},
            listOf(2, 4, 36, 78532))
    }

    @Test
    fun lengths() {
        assertEquals(lengths(listOf("kek", "rofl", "lol", "abacaba")),
            listOf(3, 4, 3, 7))
    }

    @Test
    fun sumsq0() {
        assertEquals(sumsq(0), 0)
    }
    @Test
    fun sumsq1() {
        assertEquals(sumsq(5), 55)
    }

    @Test
    fun mapAccumL() {
        assertEquals(listOf(2, 4, 8).mapAccumL(5) {x, y -> Pair(x + y, x * y)},
            Pair(19, listOf(10, 28, 88)))
    }
}