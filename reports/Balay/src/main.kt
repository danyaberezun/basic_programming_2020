package xd

fun fibonacci (n: Int): Int {
    if(n < 1)
        return -1
    if(n < 3)
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    println(fibonacci(6))
}