import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MainKtTest {
    private val root = build(0, listOf("*", "+", "5", "2", "3"))
    @Test
    fun printVisitorTest() {
        val ans = printVisitor(root)
        Assertions.assertEquals("(2+3)*5", ans.substring(1, ans.length - 1))
    }
    @Test
    fun calculateVisitorTest() {
        Assertions.assertEquals(25, calculateVisitor(root!!))
    }
    @Test
    fun expandVisitorTest() {
        Assertions.assertEquals("2*5+3*5", expandVisitor(root!!))
    }
}