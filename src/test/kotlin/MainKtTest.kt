import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

internal class MainKtTest {
    @Test
    fun quickSortTest() {
        val rightAns = listOf(4, 12, 15, 17, 18, 25, 27, 32, 41)
        val sortedArr = listOf(17, 18, 41, 12, 25, 4, 27, 32, 15)
        Assertions.assertEquals(rightAns, quickSort(sortedArr))
    }
    @Test
    fun reverseTest() {
        val rightAns = listOf(4, 12, 15, 17, 18, 25, 27, 32, 41)
        val reversedArr = listOf(41, 32, 27, 25, 18, 17, 15, 12, 4)
        Assertions.assertEquals(rightAns, reverse(reversedArr))
    }
    @Test
    fun myFilterWithFoldTest() {
        val rightAns = listOf(4, 6, 2, -34, 12, 100, 0)
        val filteredList = listOf(4, -3, 6, 2, -34, 1, 11, 121, 12, 100, 1, -1, 0, 7)
        Assertions.assertEquals(rightAns, myFilterWithFold(filteredList) { item -> item % 2 == 0 } )
    }
    @Test
    fun myFilterWithFoldRightTest() {
        val rightAns = listOf(0, 100, 12, -34, 2, 6, 4)
        val filteredList = listOf(4, -3, 6, 2, -34, 1, 11, 121, 12, 100, 1, -1, 0, 7)
        Assertions.assertEquals(rightAns, myFilterWithFoldRight(filteredList) { item -> item % 2 == 0 } )
    }
    @Test
    fun lengthsTest() {
        val rightAns = listOf(0, 2, 3, 0, 5, 6, 1)
        val stringsList = listOf("", "ab", "a b", "", "a b c", "      ", "a")
        Assertions.assertEquals(rightAns, lengths(stringsList))
    }
    @Test
    fun sumSquares() {
        Assertions.assertEquals(55, sumSquares(5))
    }
    @Test
    fun mapAccumulationTest1() {
        val rightAns = Pair(5, listOf(45, 30, 15))
        Assertions.assertEquals(rightAns, mapAccumulation(5, listOf(9, 6, 3)) { x, y -> Pair(x, x * y) } )
    }
    @Test
    fun mapAccumulationTest2() {
        val rightAns = Pair(19, listOf(10, 28, 88))
        Assertions.assertEquals(rightAns, mapAccumulation(5, listOf(2, 4, 8)) { x, y -> Pair(x + y, x * y) } )
    }
}