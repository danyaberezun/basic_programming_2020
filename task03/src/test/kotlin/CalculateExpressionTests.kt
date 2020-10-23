import main.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculateExpressionTests {

    @Test
    fun `calculateExpression expression1 test`() {
        val expression = createExpression1() //10
        val result = calculateExpression(expression)
        val answer = 10
        assertEquals(answer, result)
    }

    @Test
    fun `calculateExpression expression2 test`() {
        val expression = createExpression2() //(3 + 32) * 23
        val result = calculateExpression(expression)
        val answer = 805
        assertEquals(answer, result)
    }

    @Test
    fun `calculateExpression expression3 test`() {
        val expression = createExpression3() //20 * 15 * (6 + 9) + 12
        val result = calculateExpression(expression)
        val answer = 4512
        assertEquals(answer, result)
    }

    @Test
    fun `calculateExpression expression4 test`() {
        val expression = createExpression4() //((3 + 32) * 23 + 65 * 21) * 34
        val result = calculateExpression(expression)
        val answer = 73780
        assertEquals(answer, result)
    }

    @Test
    fun `calculateExpression expression5 test`() {
        val expression = createExpression5() //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34) * 3 + 3
        val result = calculateExpression(expression)
        val answer = 998686083
        assertEquals(answer, result)
    }
}