@file: JvmName("main")

fun main() {
    val a = Literal(1)
    val b = Literal(2)
    val res = Sum(a, b)
    val res2 = Multiply(res, res)
    println(calculateExpression(res))
    println(printExpression(res))
    println(expandExpression(res2))
}