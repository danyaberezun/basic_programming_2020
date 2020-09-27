fun main(args : Array<String>) {
    if (args.size > 1) error("Too many args")
    if (args.isEmpty()) error("Too few args")
    if (args[0].toIntOrNull() == null) error("Argument should provide number")
    println(fib(args[0].toInt()))
}

fun fib(n : Int) : Int {
    if (n == 0) return 0
    if (n == 1) return 1
    return fib(n - 1) + fib(n - 2)
}