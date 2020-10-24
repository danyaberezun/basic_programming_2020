import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class VisitorsKtTest {

    @Test
    fun `test 0 for runPrintVisitor`() {
        assertEquals("8", runPrintVisitor(Variable(8)))
    }

    @Test
    fun `test 0 for runCalculateVisitor`() {
        assertEquals(8, runCalculateVisitor(Variable(8)))
    }

    @Test
    fun `test 0 for runExpandVisitor`() {
        assertEquals(8, runExpandVisitor(Variable(8)))
    }

    @Test
    fun `test 1 for runPrintVisitor`() {
        assertEquals("(1 + 2) * 3", runPrintVisitor(buildExpressionForTest1()))
    }

    @Test
    fun `test 1 for runCalculateVisitor`() {
        assertEquals(9, runCalculateVisitor(buildExpressionForTest1()))
    }

    @Test
    fun `test 1 for runExpandVisitor`() {
        assertEquals("1 * 3 + 2 * 3", runExpandVisitor(buildExpressionForTest1()))
    }

    @Test
    fun `test 2 for runPrintVisitor`() {
        assertEquals("(1 + 2) * 3 * 5 * 5", runPrintVisitor(buildExpressionForTest2()))
    }

    @Test
    fun `test 2 for runCalculateVisitor`() {
        assertEquals(225, runCalculateVisitor(buildExpressionForTest2()))
    }

    @Test
    fun `test 2 for runExpandVisitor`() {
        assertEquals("1 * 3 * 5 * 5 + 2 * 3 * 5 * 5", runExpandVisitor(buildExpressionForTest2()))
    }

    @Test
    fun `test 3 for runPrintVisitor`() {
        assertEquals("25 * (107 + 23) * (9 + 9) + 2 * ((1 + 1) * 2 + 1 + 1) * 7",
            runPrintVisitor(buildExpressionForTest3()))
    }

    @Test
    fun `test 3 for runCalculateVisitor`() {
        assertEquals(58584, runCalculateVisitor(buildExpressionForTest3()))
    }

    @Test
    fun `test 3 for runExpandVisitor`() {
        assertEquals("25 * 107 * 9 + 25 * 107 * 9 + 25 * 23 * 9 + 25 * 23 * 9 + 2 * 1 * 2 * 7 + 2 * 1 * 2 * 7 + 2 * 1 * 7 + 2 * 1 * 7",
            runExpandVisitor(buildExpressionForTest3()))
    }

    @Test
    fun `test 4 for runPrintVisitor`() {
        assertEquals("(25 * (107 + 23) * (9 + 9) + 2 * ((1 + 1) * 2 + 1 + 1) * 7) * (1 + 2) * 3 * 5 * 5",
            runPrintVisitor(buildExpressionForTest4()))
    }

    @Test
    fun `test 4 for runCalculateVisitor`() {
        assertEquals(13181400, runCalculateVisitor(buildExpressionForTest4()))
    }

    @Test
    fun `test 4 for runExpandVisitor`() {
        assertEquals("25 * 107 * 9 * 1 * 3 * 5 * 5 + 25 * 107 * 9 * 2 * 3 * 5 * 5 + 25 * 107 * 9 * 1 * 3 * 5 * 5 + 25 * 107 * 9 * 2 * 3 * 5 * 5 + 25 * 23 * 9 * 1 * 3 * 5 * 5 + 25 * 23 * 9 * 2 * 3 * 5 * 5 + 25 * 23 * 9 * 1 * 3 * 5 * 5 + 25 * 23 * 9 * 2 * 3 * 5 * 5 + 2 * 1 * 2 * 7 * 1 * 3 * 5 * 5 + 2 * 1 * 2 * 7 * 2 * 3 * 5 * 5 + 2 * 1 * 2 * 7 * 1 * 3 * 5 * 5 + 2 * 1 * 2 * 7 * 2 * 3 * 5 * 5 + 2 * 1 * 7 * 1 * 3 * 5 * 5 + 2 * 1 * 7 * 2 * 3 * 5 * 5 + 2 * 1 * 7 * 1 * 3 * 5 * 5 + 2 * 1 * 7 * 2 * 3 * 5 * 5",
            runExpandVisitor(buildExpressionForTest4()))
    }
}