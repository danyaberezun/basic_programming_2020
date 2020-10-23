import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.exp

internal class VisitorKtTest {
    fun e(value: Int): Expression {
        return Literal(value)
    }

    val product = (e(1) + e(2)) * ((e(2) + e(3)) * e(2))
    val chain = ((e(1) + e(2)) * e(3) + e(2)) * e(4) + e(5)
    val expanded = e(2) * e(3) * e(4) + e(3) * e(4) * e(5)

    @Test
    fun printVisitorProduct() {
        assertEquals("(1 + 2) * (2 + 3) * 2", printVisitor(product))
    }
    @Test
    fun calculateVisitorProduct() {
        assertEquals(30, calculateVisitor(product))
    }
    @Test
    fun expandVisitorProduct() {
        assertEquals("1*2*2 + 1*3*2 + 2*2*2 + 2*3*2", expandVisitor(product))
    }
    @Test
    fun printVisitorChain() {
        assertEquals("((1 + 2) * 3 + 2) * 4 + 5", printVisitor(chain))
    }
    @Test
    fun calculateVisitorChain() {
        assertEquals(49, calculateVisitor(chain))
    }
    @Test
    fun expandVisitorChain() {
        assertEquals("1*3*4 + 2*3*4 + 2*4 + 5", expandVisitor(chain))
    }
    @Test
    fun printVisitorExpanded() {
        assertEquals("2 * 3 * 4 + 3 * 4 * 5", printVisitor(expanded))
    }
    @Test
    fun calculateVisitorExpanded() {
        assertEquals(84, calculateVisitor(expanded))
    }
    @Test
    fun expandVisitorExpanded() {
        assertEquals("2*3*4 + 3*4*5", expandVisitor(expanded))
    }
}