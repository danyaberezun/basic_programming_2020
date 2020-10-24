@file: JvmName("main")

fun main() {
    val a = Literal(1)
    val b = Literal(2)
    val res = Sum(a, b)
    println(calculateExpression(res))
    println(printExpression(res))
}