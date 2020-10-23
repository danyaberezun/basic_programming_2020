import org.junit.jupiter.api.Test
import main.*

import org.junit.jupiter.api.Assertions.*

internal class PrintExpressionTests {

    @Test
    fun `printExpression expression1 test`() {
        val expression = createExpression1() //10
        val result = printExpression(expression)
        val answer = "10"
        assertEquals(answer, result)
    }

    @Test
    fun `printExpression expression2 test`() {
        val expression = createExpression2() //(3 + 32) * 23
        val result = printExpression(expression)
        val answer = "(3 + 32) * 23"
        assertEquals(answer, result)
    }

    @Test
    fun `printExpression expression3 test`() {
        val expression = createExpression3() //20 * 15 * (6 + 9) + 12
        val result = printExpression(expression)
        val answer = "20 * 15 * (6 + 9) + 12"
        assertEquals(answer, result)
    }

    @Test
    fun `printExpression expression4 test`() {
        val expression = createExpression4() //((3 + 32) * 23 + 65 * 21) * 34
        val result = printExpression(expression)
        val answer = "((3 + 32) * 23 + 65 * 21) * 34"
        assertEquals(answer, result)
    }

    @Test
    fun `printExpression expression5 test`() {
        val expression = createExpression5() //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34) * 3 + 3
        val result = printExpression(expression)
        val answer = "(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34 * 3 + 3"
        assertEquals(answer, result)
    }
}