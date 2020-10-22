@file: JvmName("main")
package foo

import java.lang.RuntimeException

// If N < 0 -> F(-N) = (-1)^n+1 * F(N)
// If N > 0 -> F(N)
fun fib(n: Int): Int {
    if (n == 0) return 0;
    if (n == 1) return 1;

    fun fib_p(n: Int): Int {
        var current_val = 1;
        var prev_val = 1;
        for (i in 2..n-1) {
            var next_val = current_val + prev_val;
            prev_val = current_val;
            current_val = next_val;
        }
        return current_val;
    }
    val neg = if (n < 0 && (n % 2) == 0) { -1 } else { 1 };

    return fib_p(Math.abs(n))*neg
}

fun main() {
    val input = readLine();
    if (input == null) {
        throw RuntimeException("empty input")
    }

    val n = input.toIntOrNull();
    if (n == null) {
        throw RuntimeException("it must be an integer number in the input")
    }

    println(fib(n));
}