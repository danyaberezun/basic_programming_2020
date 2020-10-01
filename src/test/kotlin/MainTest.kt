package funqsort.test

import funqsort.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainTest {

    @Test
    fun quicksortTest() {
        val list = listOf(15, 4, 7, 89, 0, 12)
        val expected = listOf(0, 4, 7, 12, 15, 89)
        val actual: List<Int> = quicksort(list)
        assertEquals(expected, actual)
    }

    @Test
    fun reverseTest() {
        val list = listOf(15, 4, 7, 89, 0, 12)
        val expected = listOf(12, 0, 89, 7, 4, 15)
        val actual: List<Int> = reverse(list)
        assertEquals(expected, actual)
    }

    @Test
    fun filterTest() {
        val list = listOf(15, 4, 7, 89, 0, 12)
        val expected = listOf(15, 89, 12)
        val actual: List<Int> = filter(list) { it > 7 }
        assertEquals(expected, actual)
    }

    @Test
    fun filterRightTest() {
        val list = listOf(15, 4, 7, 89, 0, 12)
        val expected = listOf(12, 89, 15)
        val actual = filterRight(list) { it > 7 }
        assertEquals(expected, actual)
    }

    @Test
    fun lengthsTest() {
        val strings = listOf("aaaa", "oaoao", "xa")
        val expected = listOf(4, 5, 2)
        val actual: List<Int> = lengths(strings)
        assertEquals(expected, actual)
    }

    @Test
    fun sumsqTest() {
        val n = 5
        val expected = listOf(1, 4, 9, 16, 25)
        val actual: List<Int> = sumsq(n)
        assertEquals(expected, actual)
    }

    @Test
    fun mapAccumLTest() {
        val list = listOf(9, 6, 3)
        val expected = Pair(5, listOf(45, 30, 15))
        val actual: Pair<Int, List<Int>> = list.mapAccumL({a, b -> Pair(a, a * b)}, 5)
        assertEquals(expected, actual)
    }
}