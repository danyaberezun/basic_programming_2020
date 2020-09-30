import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class mainTest {

    @Test
    fun quickSortTest1() {
        assertEquals(quickSort(listOf(1, 5, 8, 4, 3, 2, 7, 6)), listOf(1, 2, 3, 4, 5, 6, 7, 8))
    }

    @Test
    fun quickSortTest2() {
        assertEquals(quickSort(listOf(1)), listOf(1))
    }

    @Test
    fun quickSortTest3() {
        assertEquals(quickSort(listOf(1, 2)), listOf(1, 2))
    }

    @Test
    fun quickSortTest4() {
        assertEquals(quickSort(listOf(2, 1)), listOf(1, 2))
    }

    @Test
    fun quickSortTest5() {
        assertEquals(quickSort(listOf(1, 2, 3)), listOf(1, 2, 3))
    }

    @Test
    fun quickSortTest6() {
        assertEquals(quickSort(listOf(1, 3, 2)), listOf(1, 2, 3))
    }

    @Test
    fun quickSortTest7() {
        assertEquals(quickSort(listOf(2, 1, 3)), listOf(1, 2, 3))
    }

    @Test
    fun quickSortTest8() {
        assertEquals(quickSort(listOf(2, 3, 1)), listOf(1, 2, 3))
    }

    @Test
    fun quickSortTest9() {
        assertEquals(quickSort(listOf(3, 1, 2)), listOf(1, 2, 3))
    }

    @Test
    fun quickSortTest10() {
        assertEquals(quickSort(listOf(3, 2, 1)), listOf(1, 2, 3))
    }

    @Test
    fun reverseTest1() {
        assertEquals(reverse(listOf(1, 2, 3)), listOf(3, 2, 1))
    }

    @Test
    fun reverseTest2() {
        assertEquals(reverse(listOf(1)), listOf(1))
    }

    @Test
    fun reverseTest3() {
        assertEquals(reverse(listOf(1, 2)), listOf(2, 1))
    }

    @Test
    fun reverseTest4() {
        assertEquals(reverse(listOf(1, 2, 3, 4, 5)), listOf(5, 4, 3, 2, 1))
    }

    @Test
    fun myFilterTest1() {
        assertEquals(myFilter(listOf(1, 2, 3, 4, 5)) { it < 4 }, listOf(1, 2, 3))
    }

    @Test
    fun myFilterTest2() {
        assertEquals(myFilter(listOf(1, 2, 3, 4, 5)) { it >= 4 }, listOf(4, 5))
    }

    @Test
    fun myFilterRightTest1() {
        assertEquals(myFilterRight(listOf(1, 2, 3, 4, 5)) { it < 4 }, listOf(3, 2, 1))
    }

    @Test
    fun myFilterRightTest2() {
        assertEquals(myFilterRight(listOf(1, 2, 3, 4, 5)) { it >= 4 }, listOf(5, 4))
    }

    @Test
    fun lengthsTest1() {
        assertEquals(lengths(listOf("", "a", "kek", "sos", "abacaba")), listOf(0, 1, 3, 3, 7))
    }

    @Test
    fun sumsqTest1() {
        assertEquals(sumsq(1), 1)
    }

    @Test
    fun sumsqTest2() {
        assertEquals(sumsq(10), 385)
    }

    @Test
    fun sumsqTest3() {
        assertEquals(sumsq(100), 338350)
    }

    @Test
    fun mapAccumlTest1() {
        assertEquals(listOf(9, 6, 3).mapAccumL(5) { x, y -> x to x * y }, 5 to listOf(45, 30, 15))
    }

    @Test
    fun mapAccumlTest2() {
        assertEquals(listOf(2, 4, 8).mapAccumL(5) { x, y -> x + y to x * y }, 19 to listOf(10, 28, 88))
    }

    @Test
    fun mapAccumlTest3() {
        assertEquals(listOf(2, 4, 8).mapAccumL(5) { x, y -> x + y to y }, 19 to listOf(2, 4, 8))
    }

    @Test
    fun mapAccumlTest4() {
        assertEquals(listOf(2, 4, 8).mapAccumL(5) { x, y -> y to y }, 8 to listOf(2, 4, 8))
    }

    @Test
    fun mapAccumlTest5() {
        assertEquals(listOf(2, 4, 8).mapAccumL(5) { x, y -> x to x }, 5 to listOf(5, 5, 5))
    }
}