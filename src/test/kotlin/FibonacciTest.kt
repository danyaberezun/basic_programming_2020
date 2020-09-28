package me.tests

import me.fibonacci
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class FibonacciTest {

    @Test
    fun positiveNumber() {
        val number = 5
        val expected = 5
        val actual: Int = fibonacci(number)
        assertEquals(expected, actual)
    }

    @Test
    fun zero() {
        val number = 0
        val expected = 0
        val actual: Int = fibonacci(number)
        assertEquals(expected, actual)
    }

    @Test
    fun negativeNumber() {
        val number = -16
        val expected = -987
        val actual: Int = fibonacci(number)
        assertEquals(expected, actual)
    }
}
