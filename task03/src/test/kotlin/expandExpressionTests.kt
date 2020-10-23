import main.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class expandExpressionTests {

    @Test
    fun `expandExpression expression1 test`() {
        val expression = createExpression1() //10
        val result = expandExpression(expression)
        val answer = "10"
        assertEquals(answer, result)
    }

    @Test
    fun `expandExpression expression2 test`() {
        val expression = createExpression2() //(3 + 32) * 23
        val result = expandExpression(expression)
        val answer = "3 * 23 + 32 * 23"
        assertEquals(answer, result)
    }

    @Test
    fun `expandExpression expression3 test`() {
        val expression = createExpression3() //20 * 15 * (6 + 9) + 12
        val result = expandExpression(expression)
        val answer = "20 * 15 * 6 + 20 * 15 * 9 + 12"
        assertEquals(answer, result)
    }

    @Test
    fun `expandExpression expression4 test`() {
        val expression = createExpression4() //((3 + 32) * 23 + 65 * 21) * 34
        val result = expandExpression(expression)
        val answer = "3 * 23 * 34 + 32 * 23 * 34 + 65 * 21 * 34"
        assertEquals(answer, result)
    }

    @Test
    fun `expandExpression expression5 test`() {
        val expression = createExpression5() //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34) * 3 + 3
        val result = expandExpression(expression)
        val answer = "20 * 15 * 6 * 3 * 23 * 34 * 3 + 20 * 15 * 6 * 32 * 23 * 34 * 3 + 20 * 15 * 6 * 65 * 21 * 34 * 3 + 20 * 15 * 9 * 3 * 23 * 34 * 3 + 20 * 15 * 9 * 32 * 23 * 34 * 3 + 20 * 15 * 9 * 65 * 21 * 34 * 3 + 12 * 3 * 23 * 34 * 3 + 12 * 32 * 23 * 34 * 3 + 12 * 65 * 21 * 34 * 3 + 3"
        assertEquals(answer, result)
    }
}