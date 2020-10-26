import org.junit.jupiter.api.Test
import program.*

import org.junit.jupiter.api.Assertions.*
import program.PrintVisitor

internal class PrintVisitor {

    @Test
    fun `one`() {
        val expression = expression1()
        val result = expression.accept(PrintVisitor())
        val answer = "10"
        assertEquals(answer, result)
    }

    @Test
    fun `equal`() {
        val expression = expression2()
        val result = expression.accept(PrintVisitor())
        val answer = "((23 * 23) + (23 + 23))"
        assertEquals(answer, result)
    }

    @Test
    fun `diff`() {
        val expression = expression3()
        val result = expression.accept(PrintVisitor())
        val answer = "(((10 * 20) + (5 + 6)) * 10)"
        assertEquals(answer, result)
    }
}