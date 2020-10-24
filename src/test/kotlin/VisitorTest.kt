import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class VisitorTest {
    private val a = Literal(1)
    private val b = Literal(2)
    private val sum = Sum(a, b)
    private val squareOfSum = Multiply(sum, sum)
    @Test
    fun calculateLiteralExpression() {
        assertEquals(1, calculateExpression(a))
    }
    @Test
    fun calculateSumExpression() {
        assertEquals(3, calculateExpression(sum))
    }
    @Test
    fun calculateCombinedExpression() {
        assertEquals(9, calculateExpression(squareOfSum))
    }
    @Test
    fun printLiteralExpression() {
        assertEquals("1", printExpression(a))
    }
    @Test
    fun printSumExpression() {
        assertEquals("1 + 2", printExpression(sum))
    }
    @Test
    fun printCombinedExpression() {
        assertEquals("(1 + 2) * (1 + 2)", printExpression(squareOfSum))
    }
    @Test
    fun expandLiteral() {
        assertEquals("1", expandExpression(a))
    }
    @Test
    fun expandSumExpression() {
        assertEquals("1 + 2", expandExpression(sum))
    }
    @Test
    fun expandCombinedExpression() {
        assertEquals("1 * 1 + 1 * 2 + 2 * 1 + 2 * 2", expandExpression(squareOfSum))
    }
}