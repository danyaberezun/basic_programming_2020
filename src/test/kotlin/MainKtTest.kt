import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun qSortNoElements() {
        assertEquals(quickSort(listOf()), listOf<Int>())
    }

    @Test
    fun qSortOneElement() {
        assertEquals(quickSort(listOf(1)), listOf(1))
    }

    @Test
    fun qSortConsecutiveElements() {
        assertEquals(quickSort(listOf(5, 7, 6, 2, 4, 3, 1)), listOf(1, 2, 3, 4, 5, 6, 7))
    }

    @Test
    fun qSortRandomElements() {
        assertEquals(quickSort(listOf(356, 153, 967, 12, -43, 0)), listOf(-43, 0, 12, 153, 356, 967))
    }

    @Test
    fun reverse() {
        assertEquals(reverse(listOf(967, 356, 153, 12, 0, -43)), listOf(-43, 0, 12, 153, 356, 967))
    }

    @Test
    fun filterViaFold() {
        val test = listOf(-1, 0, 1, 23, -22, 100, -1000)
        assertEquals(filterViaFold(test) { it > 0 }, test.filter { it > 0 })
    }

    @Test
    fun filterViaFoldRight() {
        val test = listOf(-1, 0, 1, 23, -22, 100, -1000)
        assertEquals(filterViaFold(test) { it > 0 }, test.filter { it > 0 })
    }

    @Test
    fun lengths() {
        assertEquals(
            lengths(listOf("aaaaaaaaa", "abab", "", "a", "sdhgjkfkhjgsdfksld")),
            listOf(9, 4, 0, 1, 18)
        )
    }

    @Test
    fun sumsq0() {
        assertEquals(sumsq(0), 0)
    }

    @Test
    fun sumsq1() {
        assertEquals(sumsq(1), 1)
    }

    @Test
    fun sumsq4() {
        assertEquals(sumsq(4), 30)
    }

    @Test
    fun mapAccumLXIsSame() {
        assertEquals(
            listOf(9, 6, 3).mapAccumL(5) { x, y -> Pair(x, x * y) },
            Pair(5, listOf(45, 30, 15))
        )
    }

    @Test
    fun mapAccumLXAndY() {
        assertEquals(
            listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(x + y, x * y) },
            Pair(19, listOf(10, 28, 88))
        )
    }

    @Test
    fun mapAccumLYIsSame() {
        assertEquals(
            listOf(2, 4, 8).mapAccumL(5) { x, y -> Pair(x + y, y) },
            Pair(19, listOf(2, 4, 8))
        )
    }
}