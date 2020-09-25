fun fibonacci(x: Int): Int {
    if (x == 1 || x == 2)
        return 1
    return fibonacci(x - 1) + fibonacci(x - 2)
}

fun main(args: Array<String>) {
    println(fibonacci(args[0].toInt()))
}