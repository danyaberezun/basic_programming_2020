import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import smth.*

internal class MainKtTest {

    @Test
    fun `quicksort test`() {
        val toSort = listOf(10, 5, 4, 3, 2, 6, 7, 1, 8, 12, 1000)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 1000), quicksort(toSort))
    }

    @Test
    fun `quicksort test (already sorted)`() {
        val toSort = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(toSort, quicksort(toSort))
    }


    @Test
    fun `reverse test`() {
        val toReverse = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(5, 4, 3, 2, 1), reverse(toReverse))
    }


    @Test
    fun `myFilter test`() {
        val toFilter = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        assertEquals(listOf(1, 2, 3, 4, 0), myFilter(toFilter))
    }


    @Test
    fun `lengths test`() {
        val strings = listOf("", "1", "22", "333", "4444", "1234567890")
        assertEquals(listOf(0, 1, 2, 3, 4, 10), lengths(strings))
    }


    @Test
    fun `sumsq test`() {
        assertEquals(385, sumsq(10))
    }

    @Test
    fun `sumsq 0 test`() {
        assertEquals(0, sumsq(0))
    }


    @Test
    fun `mapAccumL (nothing, *) test`() {
        val x = 5
        val y = listOf(9, 6, 3)
        assertEquals(Pair(5, listOf(45, 30, 15)), mapAccumL(x, y, '.', '*'))
    }

    @Test
    fun `mapAccumL (+, *) test`() {
        val x = 5
        val y = listOf(2, 4, 8)
        assertEquals(Pair(19, listOf(10, 28, 88)), mapAccumL(x, y, '+', '*'))
    }

    @Test
    fun `mapAccumL (+, nothing) test`() {
        val x = 5
        val y = listOf(2, 4, 8)
        assertEquals(Pair(19, listOf(2, 4, 8)), mapAccumL(x, y, '+', '.'))
    }

    @Test
    fun `mapAccumL (y, y) test`() {
        val x = 5
        val y = listOf(2, 4, 8)
        assertEquals(Pair(8, listOf(2, 4, 8)), mapAccumL(x, y, '=', '.'))
    }

    @Test
    fun `mapAccumL (x, x) test`() {
        val x = 5
        val y = listOf(2, 4, 8)
        assertEquals(Pair(5, listOf(5, 5, 5)), mapAccumL(x, y, '.', '='))
    }
}