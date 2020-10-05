package functional.tests

import functional.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun `quicksort (empty list)`() {
        assertEquals(listOf<Int>(), quicksort(listOf()))
    }

    @Test
    fun `quicksort (not empty list)`() {
        assertEquals(listOf(2, 5, 6, 10, 12, 23), quicksort(listOf(12, 23, 6, 10, 2, 5)))
    }

    @Test
    fun `reverse (empty list)`() {
        assertEquals(listOf<Int>(), reverse(listOf()))
    }

    @Test
    fun `reverse (not empty list)`() {
        assertEquals(listOf(1, 2, 3, 4, 5), reverse(listOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `filter_withFold`() {
        val isEven: (Int) -> Boolean = { it % 2 == 0 }
        assertEquals(listOf(10, 4, 8), filter_withFold(listOf(5, 7, 10, 1, 4, 8, 7), isEven))
    }

    @Test
    fun `filter_withFoldRight`() {
        val isEven: (Int) -> Boolean = { it % 2 == 0 }
        assertEquals(listOf(10, 4, 8), filter_withFoldRight(listOf(5, 7, 10, 1, 4, 8, 7), isEven))
    }

    @Test
    fun `lengths`() {
        assertEquals(listOf(4, 0, 8), lengths(listOf("aaa ", "", "5tgfihjb")))
    }

    @Test
    fun `sumsq (null)`() {
        assertEquals(0, sumsq(0))
    }

    @Test
    fun `sumsq`() {
        assertEquals(55, sumsq(5))
    }

    @Test
    fun `mapAccumL`() {
        assertEquals(Pair(7, listOf(63, 42, 21)), listOf(9, 6, 3).mapAccumL(7) { x, y -> Pair(x, x * y)})
    }
}