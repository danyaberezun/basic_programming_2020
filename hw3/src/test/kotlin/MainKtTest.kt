import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun quicksortEmpty() {
        assertEquals(listOf<Int>(), quicksort(listOf<Int>()))
    }
    @Test
    fun quicksort() {
        assertEquals(listOf(1, 2, 2, 3, 4, 7, 9), quicksort(listOf(1, 9, 2, 7, 4, 2, 3)))
    }

    @Test
    fun reverse() {
        assertEquals(listOf(4, 9, 1), reverse(listOf(1, 9, 4)))
    }

    @Test
    fun filter() {
        assertEquals(listOf(2, 4, 80, 2), filter(listOf(2, 5, 4, 1, 80, 2)) { it % 2 == 0 })
    }

    @Test
    fun filterRight() {
        assertEquals(listOf(2, 4, 80, 2), filterRight(listOf(2, 5, 4, 1, 80, 2)) { it % 2 == 0 })
    }

    @Test
    fun lengths() {
        assertEquals(listOf(3, 0, 2), lengths(listOf("123", "", "aa")))
    }

    @Test
    fun sumsq0() {
        assertEquals(0, sumsq(0))
    }

    @Test
    fun sumsq() {
        assertEquals(14, sumsq(3))
    }

    @Test
    fun mapAccumL() {
        assertEquals(19 to listOf(10, 28, 88), listOf(2, 4, 8).mapAccumL({ x, y -> x + y to x * y }, 5))
    }
}