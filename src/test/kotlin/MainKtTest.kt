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

}