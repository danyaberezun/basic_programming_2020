import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VisitorKtTest {

    fun expression(): Node {
        val firstNumber = Number(2)
        val secondNumber = Number(3)
        val thirdNumber = Number(5)
        return Product(firstNumber, Sum(secondNumber, thirdNumber))
    }

    @Test
    fun PrintVisitorTest() {
        assertEquals("(2 * (3 + 5))", expression().visit(PrintVisitor()))
    }

    @Test
    fun CalculateVisitorTest() {
        assertEquals(16, expression().visit(CalculateVisitor()))
    }
}