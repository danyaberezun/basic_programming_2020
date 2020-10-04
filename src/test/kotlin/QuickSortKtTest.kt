import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuickSortKtTest {

    @Test
    fun `empty list test for quickSort`() {
        assertEquals(listOf<Int>(), quickSort(listOf()))
    }

    @Test
    fun `one element list test for quickSort`() {
        assertEquals(listOf(1), quickSort(listOf(1)))
    }

    @Test
    fun `sorted list test for quickSort`() {
        assertEquals(listOf(1, 2, 4), quickSort(listOf(1, 2, 4)))
    }

    @Test
    fun `unsorted list test for quickSort`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7), quickSort(listOf(1, 3, 6, 5, 2, 4, 7)))
    }

    @Test
    fun `empty list test for reverse`() {
        assertEquals(listOf<Int>(), reverse(listOf()))
    }

    @Test
    fun `not empty list test for reverse`() {
        assertEquals(listOf(7, 4, 2, 5, 6, 3, 1), reverse(listOf(1, 3, 6, 5, 2, 4, 7)))
    }

    @Test
    fun `simple test for filter`() {
        val isEven: (Int) -> Boolean = { it % 2 == 0 }
        assertEquals(listOf(6, 2, 4), filter(listOf(1, 3, 6, 5, 2, 4, 7), isEven))
    }

    @Test
    fun `simple test for filterRight`() {
        val isEven: (Int) -> Boolean = { it % 2 == 0 }
        assertEquals(listOf(6, 2, 4), filterRight(listOf(1, 3, 6, 5, 2, 4, 7), isEven))
    }

    @Test
    fun `simple test for lengths`() {
        assertEquals(listOf(3, 0, 1, 11, 3, 3, 5), lengths(listOf("aba", "", "a", "abracadabra", "pog", "kek", "nsivo")))
    }

    @Test
    fun `0 test for sumsq`() {
        assertEquals(0, sumsq(0))
    }

    @Test
    fun `1 test for sumsq`() {
        assertEquals(1, sumsq(1))
    }

    @Test
    fun `simple test for sumsq`() {
        assertEquals(55, sumsq(5))
    }

    @Test
    fun `Example1 test for mapAccumL`() {
        assertEquals(Pair(5, listOf(45, 30, 15)), listOf(9, 6, 3).mapAccumL(5) { x, y -> Pair(x, x * y) })
    }

    @Test
    fun `Example2 test for mapAccumL`() {
        assertEquals(Pair(19, listOf(10, 28, 88)), listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(x + y, x * y) })
    }

    @Test
    fun `Example3 test for mapAccumL`() {
        assertEquals(Pair(19, listOf(2, 4, 8)), listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(x + y, y) })
    }

    @Test
    fun `Example4 test for mapAccumL`() {
        assertEquals(Pair(8, listOf(2, 4, 8)), listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(y, y) })
    }

    @Test
    fun `Example5 test for mapAccumL`() {
        assertEquals(Pair(5, listOf(5, 5, 5)), listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(x, x) })
    }
}