import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FibonacciTest {
    @Test
    fun isFirstFibonacciNumberEquals1() {
        Assertions.assertEquals(1, fibonacci(1))
    }
    @Test
    fun isSecondFibonacciNumberEquals1() {
        Assertions.assertEquals(1, fibonacci(2))
    }
    @Test
    fun isThirdFibonacciNumberEquals2() {
        Assertions.assertEquals(2, fibonacci(3))
    }
    @Test
    fun isFourthFibonacciNumberEquals3() {
        Assertions.assertEquals(3, fibonacci(4))
    }
    @Test
    fun isFifthFibonacciNumberEquals5() {
        Assertions.assertEquals(5, fibonacci(5))
    }
    @Test
    fun isTenthFibonacciNumberEquals55() {
        Assertions.assertEquals(55, fibonacci(10))
    }
}