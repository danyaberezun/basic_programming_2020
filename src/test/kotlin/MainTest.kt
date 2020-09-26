import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import src.*

internal class MainKtTest {

    @Test
    fun getNthFibonacci() {
        var a = 1
        var b = 1
        for (i in 1..30){
            assertEquals(a, getNthFibonacci(1, 1, i))
            b += a
            a = b - a
        }
        a = 1
        b = 1
        for (i in 1 downTo -30){
            assertEquals(a, getNthFibonacci(1, 1, i))
            a = b - a
            b = b - a
        }
    }

    @Test
    fun checkInput() {
        assertEquals(true, checkInput("1 1 1"))
        assertEquals(true, checkInput("1 111 1"))
        assertEquals(true, checkInput("1 11 111"))
        assertEquals(true, checkInput("111 1 1"))
        assertEquals(true, checkInput("1 111 11"))

        assertEquals(false, checkInput(""))
        assertEquals(false, checkInput("1"))
        assertEquals(false, checkInput("1 1"))
        assertEquals(false, checkInput("1 1 a"))
    }
}