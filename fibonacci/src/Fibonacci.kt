
fun main(args : Array<String>) {
    // Проверка аргументов
    if (args.size > 1) error("Too many args")
    if (args.isEmpty()) error("Too few args")
    if (args[0].toIntOrNull() == null || (args[0].toInt() < 0)) error("Argument should provide number above zero")
    println(fib(args[0].toInt()))
}

// Рекурсивный Фибоначи
fun fib(n : Int) : Int {
    if (n == 0) return 0
    if (n == 1) return 1
    return fib(n - 1) + fib(n - 2)
}