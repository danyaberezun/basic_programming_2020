import java.lang.Exception

// The result of this function can be incorrect for negative values of n!
fun fibonacci(n: Int): Int {
    var curFirst = 1
    var curSecond = 0
    for (i in 1..n) {
        curSecond += curFirst
        curFirst = curSecond - curFirst
    }
    return curSecond
}

fun main(args: Array<String>) {
    val n = try {
        args[0].toInt()
    } catch (e: Exception) {
        throw Exception("Wrong input")
    }
    println(fibonacci(n))
}