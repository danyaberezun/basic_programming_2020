package vis.tests

import vis.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class PrintVisitorTest {

    @Test
    fun test1() {
        val action: Action = (Value(14) + Value(1)) * ((Value(9) + Value(6)) * Value(3))
        val expected = "(14 + 1) * (9 + 6) * 3"
        val actual: String = printVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val action: Action = ((Value(7) + Value(4)) * Value(19) + Value(6)) * Value(13) + Value(13)
        val expected = "((7 + 4) * 19 + 6) * 13 + 13"
        val actual: String = printVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val action: Action = Value(11) * Value(1) * Value(0) + Value(6) * Value(2) * Value(16)
        val expected = "11 * 1 * 0 + 6 * 2 * 16"
        val actual: String = printVisitor(action)
        assertEquals(expected, actual)
    }
}

internal class CalculateVisitorTest {

    @Test
    fun test1() {
        val action: Action = (Value(14) + Value(1)) * ((Value(9) + Value(6)) * Value(3))
        val expected = 675
        val actual: Int = calculateVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val action: Action = ((Value(7) + Value(4)) * Value(19) + Value(6)) * Value(13) + Value(13)
        val expected = 2808
        val actual: Int = calculateVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val action: Action = Value(11) * Value(1) * Value(0) + Value(6) * Value(2) * Value(16)
        val expected = 192
        val actual: Int = calculateVisitor(action)
        assertEquals(expected, actual)
    }
}

internal class ExpandVisitorTest {

    @Test
    fun test1() {
        val action: Action = (Value(14) + Value(1)) * ((Value(9) + Value(6)) * Value(3))
        val expected = "14 * 9 * 3 + 14 * 6 * 3 + 1 * 9 * 3 + 1 * 6 * 3"
        val actual: String = expandVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val action: Action = ((Value(7) + Value(4)) * Value(19) + Value(6)) * Value(13) + Value(13)
        val expected = "7 * 19 * 13 + 4 * 19 * 13 + 6 * 13 + 13"
        val actual: String = expandVisitor(action)
        assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val action: Action = Value(11) * Value(1) * Value(0) + Value(6) * Value(2) * Value(16)
        val expected = "11 * 1 * 0 + 6 * 2 * 16"
        val actual: String = expandVisitor(action)
        assertEquals(expected, actual)
    }
}
