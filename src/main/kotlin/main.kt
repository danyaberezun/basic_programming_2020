fun fibonacci(value: Int): Int {
    if (value < 2) return 1
    else return fibonacci(value - 1) + fibonacci(value - 2)
}

fun main(args: Array<String>) {
    println(fibonacci(args[0].toInt()))
}