import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun `test 0 for runPrintVisitor`() {
        assertEquals("8", printVisitor(Variable(8)))
    }

    @Test
    fun `test 0 for runCalculateVisitor`() {
        assertEquals(8, calculateVisitor(Variable(8)))
    }

    @Test
    fun `test 0 for runExpandVisitor`() {
        assertEquals("8", expandVisitor(Variable(8)))
    }

    @Test
    fun `test 1 for runPrintVisitor`() {
        assertEquals("(1 + 2) * 3", printVisitor(test1()))
    }

    @Test
    fun `test 1 for runCalculateVisitor`() {
        assertEquals(9, calculateVisitor(test1()))
    }

    @Test
    fun `test 1 for runExpandVisitor`() {
        assertEquals("1 * 3 + 2 * 3", expandVisitor(test1()))
    }

    @Test
    fun `test 2 for runPrintVisitor`() {
        assertEquals("(1 + 2) * 3 * 5 * 5", printVisitor(test2()))
    }

    @Test
    fun `test 2 for runCalculateVisitor`() {
        assertEquals(225, calculateVisitor(test2()))
    }

    @Test
    fun `test 2 for runExpandVisitor`() {
        assertEquals("1 * 3 * 5 * 5 + 2 * 3 * 5 * 5", expandVisitor(test2()))
    }

    @Test
    fun `test 3 for runPrintVisitor`() {
        assertEquals(
            "239 * (104 + 23) * (1 + 1) + 2 * ((2 + 2) * 2 + 2 + 2) * 3",
            printVisitor(test3())
        )
    }

    @Test
    fun `test 3 for runCalculateVisitor`() {
        assertEquals(60778, calculateVisitor(test3()))
    }

    @Test
    fun `test 3 for runExpandVisitor`() {
        assertEquals(
            "239 * 104 * 1 + 239 * 104 * 1 + 239 * 23 * 1 + 239 * 23 * 1 + 2 * 2 * 2 * 3 + 2 * 2 * 2 * 3 + 2 * 2 * 3 + 2 * 2 * 3",
            expandVisitor(test3())
        )
    }

    @Test
    fun `test 4 for runPrintVisitor`() {
        assertEquals(
            "(239 * (104 + 23) * (1 + 1) + 2 * ((2 + 2) * 2 + 2 + 2) * 3) * (1 + 2) * 3 * 5 * 5",
            printVisitor(test4())
        )
    }

    @Test
    fun `test 4 for runCalculateVisitor`() {
        assertEquals(13675050, calculateVisitor(test4()))
    }

    @Test
    fun `test 4 for runExpandVisitor`() {
        assertEquals(
            "239 * 104 * 1 * 1 * 3 * 5 * 5 + 239 * 104 * 1 * 2 * 3 * 5 * 5 + 239 * 104 * 1 * 1 * 3 * 5 * 5 + 239 * 104 * 1 * 2 * 3 * 5 * 5 + 239 * 23 * 1 * 1 * 3 * 5 * 5 + 239 * 23 * 1 * 2 * 3 * 5 * 5 + 239 * 23 * 1 * 1 * 3 * 5 * 5 + 239 * 23 * 1 * 2 * 3 * 5 * 5 + 2 * 2 * 2 * 3 * 1 * 3 * 5 * 5 + 2 * 2 * 2 * 3 * 2 * 3 * 5 * 5 + 2 * 2 * 2 * 3 * 1 * 3 * 5 * 5 + 2 * 2 * 2 * 3 * 2 * 3 * 5 * 5 + 2 * 2 * 3 * 1 * 3 * 5 * 5 + 2 * 2 * 3 * 2 * 3 * 5 * 5 + 2 * 2 * 3 * 1 * 3 * 5 * 5 + 2 * 2 * 3 * 2 * 3 * 5 * 5",
            expandVisitor(test4())
        )
    }
}