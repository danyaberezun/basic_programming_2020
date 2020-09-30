import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuicksortTests {

    @Test
    fun `quicksort test unsorted list`() {
        val testList = listOf(3, 5, 2, 1)
        val ansList = listOf(1, 2, 3, 5)
        assertEquals(ansList, hw3.quicksort(testList))
    }

    @Test
    fun `quicksort test sorted list`() {
        val testList = listOf(1, 2, 3, 5)
        val ansList = listOf(1, 2, 3, 5)
        assertEquals(ansList, hw3.quicksort(testList))
    }

    @Test
    fun `quicksort test reverse sorted list`() {
        val testList = listOf(5, 3, 2, 1)
        val ansList = listOf(1, 2, 3, 5)
        assertEquals(ansList, hw3.quicksort(testList))
    }

    @Test
    fun `quicksort test single element list`() {
        val testList = listOf(1)
        val ansList = listOf(1)
        assertEquals(ansList, hw3.quicksort(testList))
    }

    @Test
    fun `quicksort test empty list`() {
        val testList: List<Int> = listOf()
        val ansList: List<Int> = listOf()
        assertEquals(ansList, hw3.quicksort(testList))
    }
}