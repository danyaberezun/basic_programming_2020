@file: JvmName("main")
package kek

import java.lang.RuntimeException

/**
 * f_0 = 0
 * f_1 = 1
 * \forall n > 1 : f_n = f_{n-1} + f_{n-2}
 * \forall n > 0 : f_{-n}=(-1)^{n+1} \cdot f_n
 */
fun fibonacci(n: Int): Int {
    if (n < 0) {
        var result = fibonacci(-n)
        if ((-n) % 2 == 0) {
            result *= -1
        }
        return result
    }
    if (n == 0) {
        return 0
    }
    var currentValue = 1
    var previousValue = 0
    for (i in 2..n) {
        val nextValue = previousValue + currentValue
        previousValue = currentValue
        currentValue = nextValue
    }
    return currentValue
}

fun main() {
    val input = readLine()
    if (input == null) {
        throw RuntimeException("input is empty")
    }
    val n = input.toIntOrNull()
    if (n == null) {
        throw RuntimeException("it must be integer number in the input")
    }
    println(fibonacci(n))
}