import org.junit.jupiter.api.Assertions.assertEquals
import src.*


internal class MainKtTest {

    @org.junit.jupiter.api.Test
    fun reverse(){
        val list = (1..10).toList()
        assertEquals(list.reversed(), reverse(list))
    }

    @org.junit.jupiter.api.Test
    fun filter(){
        val list = (1..10).toList()
        val isEven = {x: Int -> x % 2 == 0}
        assertEquals(list.filter(isEven), filter(list, isEven))
    }

    @org.junit.jupiter.api.Test
    fun filterRight(){
        val list = (1..10).toList()
        val isEven = {x: Int -> x % 2 == 0}
        assertEquals(list.filter(isEven), filterRight(list, isEven))
    }

    @org.junit.jupiter.api.Test
    fun lengths(){
        val list = listOf("1233", "34532323", "1", "", "42")
        assertEquals(listOf(4, 8, 1, 0, 2), lengths(list))
    }

    @org.junit.jupiter.api.Test
    fun sumsq(){
        var sum = 0
        for(i in 0..100){
            sum += i*i
            assertEquals(sum, sumsq(i))
        }
    }

    @org.junit.jupiter.api.Test
    fun mapAccumL(){
        assertEquals(Pair(5, listOf(45, 30, 15)), listOf(9, 6, 3).mapAccumL({x:Int, y:Int -> Pair(x, x*y)}, 5))
        assertEquals(Pair(19, listOf(10, 28, 88)), listOf(2, 4, 8).mapAccumL({x:Int, y:Int -> Pair(x+y, x*y)}, 5))
        assertEquals(Pair(19, listOf(2, 4, 8)), listOf(2, 4, 8).mapAccumL({x:Int, y:Int -> Pair(x+y, y)}, 5))
        assertEquals(Pair(8, listOf(2, 4, 8)), listOf(2, 4, 8).mapAccumL({x:Int, y:Int -> Pair(y, y)}, 5))
        assertEquals(Pair(5, listOf(5, 5, 5)), listOf(2, 4, 8).mapAccumL({x:Int, y:Int -> Pair(x, x)}, 5))

    }

}