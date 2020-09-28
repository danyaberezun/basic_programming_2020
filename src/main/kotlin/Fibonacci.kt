package me

/**
 * Computes the [n]-th member of the Fibonacci sequence.
 *
 * @param n Number of the member of the sequence.
 * @return The [n]-th member of the Fibonacci sequence.
 */
fun fibonacci(n: Int): Int {
    // For negative values of n: F(n) = (-1)^(n + 1) * F(-n)
    if (n < 0) {
        return if ((n + 1) % 2 == 0) {
            fibonacci(-n)
        } else {
            -fibonacci(-n)
        }
    }

    var current = 0
    var next = 1
    for (i in 1..n) {
        val sum: Int = current + next
        current = next
        next = sum
    }
    return current
}

fun main(args: Array<String>) {
    val numbers: List<Int> = args.map { it.toInt() }
    val results: List<Int> = numbers.map { fibonacci(it) }
    results.map { print("$it ") }
}
