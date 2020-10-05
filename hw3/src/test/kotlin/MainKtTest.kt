import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @org.junit.jupiter.api.Test
    fun quickSortTest() {
        val startList = listOf(3, 4, 6, 1, 2, 6, 7, 3, 2, 4)
        val expected = listOf(1, 2, 2, 3, 3, 4, 4, 6, 6, 7)
        val actual = quickSort(startList)
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun reverseTestSimpleArray() {
        val startList = listOf(3, 4, 6, 1, 2, 6, 7, 3, 2, 4)
        val expected = listOf(4, 2, 3, 7, 6, 2, 1, 6, 4, 3)
        val actual = reverse(startList)
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun filterWithFoldTestSimpleArray() {
        val startList = listOf(3, 4, 6, 1, 2, 6, 7, 3, 2, 4)
        val expected = listOf(3, 4, 1, 2, 3, 2, 4)
        val actual = filterWithFold(startList, { it < 5 })
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun filterWithFoldRightTestSimpleArray() {
        val startList = listOf(3, 4, 6, 1, 2, 6, 7, 3, 2, 4)
        val expected = listOf(2, 2, 1)
        val actual = filterWithFoldRight(startList, { it * 2 < 5 })
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun lengthsTestSimpleArray() {
        val startList = listOf("3234", "4213", "612", "132", "2s", "62", "711", "233", "2231", "41")
        val expected = listOf(4, 4, 3, 3, 2, 2, 3, 3, 4, 2)
        val actual = lengths(startList)
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun sumSquaresTest12() {
        val startNumber = 12
        val expected = 650
        val actual = sumSquares(startNumber)
        Assertions.assertEquals(expected, actual)
    }

    @org.junit.jupiter.api.Test
    fun mapAccumulationTest1Formultiply() {
        val startList = listOf(12, 23, 430, 23, 1, 2)
        val startNumber = 4
        val expected = Pair(4, listOf(48, 92, 1720, 92, 4, 8))
        val actual = mapAccumulation(startNumber, startList, { x, y -> Pair(x, x * y) })
        Assertions.assertEquals(actual, expected)
    }

    @org.junit.jupiter.api.Test
    fun mapAccumulationTest2ForPlus() {
        val startList = listOf(12, 23, 430, 23, 1, 2)
        val startNumber = 4
        val expected = Pair(4, listOf(16, 27, 434, 27, 5, 6))
        val actual = mapAccumulation(startNumber, startList, { x, y -> Pair(x, x + y) })
        Assertions.assertEquals(actual, expected)
    }
}