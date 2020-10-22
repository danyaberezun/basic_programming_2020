package foo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class mainTest {
    @Test
    fun `qsort should sort empty array`() {
        var x: List<Int> = listOf();
        assertEquals(x, foo.qsort(x))
    }

    @Test
    fun `qsort should sort full array`() {
        var x = listOf(0, 243, 2, 3, 4, 3, 3, 5, 3, 4, 2, 4234, 433, 22)
        assertEquals(x.sorted(), foo.qsort(x))
    }

    @Test
    fun `reverse should reverse a full array`() {
        var x = listOf(0, 243, 2, 3, 4, 3, 3, 5, 3, 4, 2, 4234, 433, 22, -10)
        assertEquals(x.reversed(), foo.reverse(x))
    }

    @Test
    fun `filter should filter a full array`() {
        var x = listOf(0, 243, 2, 3, 4, 3, 3, 5, 3, 4, 2, 4234, 433, 22, -10)
        assertEquals(x.filter { it > 2 }, foo.filter(x))
    }
    @Test
    fun `filter_r should reverse a full array`() {
        var x = listOf(0, 243, 2, 3, 4, 3, 3, 5, 3, 4, 2, 4234, 433, 22, -10)
        assertEquals(x.filter { it > 2 }, foo.filter_r(x))
    }
    @Test
    fun `sumq should return a sum of array`() {
        var x = listOf(1,2,3,4,5,6).fold(0, { acc: Int, i: Int -> acc + (i*i) })
        assertEquals(x, foo.sumq(6))
    }

    @Test
    fun `mapAccumL should return a sum of array`() {
        val x1 = listOf(9,6,3);
        val y1 = { x: Int, y: Int -> Pair(x, x*y)}
        assertEquals(Pair(5, listOf(45, 30, 15)), foo.mapAccumL(y1, 5, x1))

        val x2 = listOf(2,4,8);
        val y2 = { x: Int, y: Int -> Pair(x+y, x*y)}
        assertEquals(Pair(19,listOf(10,28,88)), foo.mapAccumL(y2, 5, x2))
    }


}