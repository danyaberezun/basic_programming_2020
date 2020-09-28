package smth

fun fibon(n: Int): Int {
    if (n < 3)
        return 1
    return fibon(n - 1) + fibon(n - 2)
}

fun main() {
    println(fibon(11))
}