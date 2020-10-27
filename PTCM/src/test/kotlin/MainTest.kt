import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.ArrayList

internal class MainTest {
    @Test
    fun getWordsTest() {
        val str = "привет 1 человек"
        assertEquals(getWords(str).toString(), "[привет, 1, человек]")
    }

    @Test
    fun interpretTest() {
        val arrays = ArrayList<String>()
        arrays.add("inc")
        arrays.add("y")
        interpret(arrays)
        assertEquals(y, 1)
    }

}