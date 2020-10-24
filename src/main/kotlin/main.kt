@file: JvmName("main")

interface Expr {
    fun calc(): Int
    override fun toString(): String
}

class Var(x: Int) : Expr {
    val value = x

    override fun calc(): Int {
        return value
    }

    override fun toString(): String {
        return "$value"
    }
}

class Sum(a: Expr, b: Expr) : Expr {
    val left = a
    val right = b

    override fun calc(): Int {
        return left.calc() + right.calc()
    }

    override fun toString(): String {
        return "($left + $right)"
    }
}

class Mul(a: Expr, b: Expr) : Expr {
    val left = a
    val right = b

    override fun calc(): Int {
        return left.calc() * right.calc()
    }

    override fun toString(): String {
        return "$left * $right"
    }
}

fun main() {
    println("${Mul(Sum(Var(2), Var(3)), Var(4))} = ${Mul(Sum(Var(2), Var(3)), Var(4)).calc()}")
    println("${Mul(Sum(Sum(Var(2), Var(2)), Mul(Sum(Mul(Var(2), Var(4)), Var(3)), Var(4))), Var(10))} = ${Mul(Sum(Sum(Var(2), Var(2)), Mul(Sum(Mul(Var(2), Var(4)), Var(3)), Var(4))), Var(10)).calc()}")
    println("${Var(5)} = ${Var(5).calc()}")
    println("${Sum(Var(2), Var(3))} = ${Sum(Var(2), Var(3)).calc()}")
    println("${Mul(Var(2), Var(2))} = ${Mul(Var(2), Var(2)).calc()}")
    println("${Mul(Var(3), Sum(Var(4), Var(5)))} = ${Mul(Var(3), Sum(Var(4), Var(5))).calc()}")
    println("${Sum(Mul(Var(3), Var(3)), Mul(Var(4), Var(4)))} = ${Sum(Mul(Var(3), Var(3)), Mul(Var(4), Var(4))).calc()}")
    println("${Sum(Sum(Sum(Sum(Var(1), Var(2)), Var(3)), Var(4)), Var(5))} = ${Sum(Sum(Sum(Sum(Var(1), Var(2)), Var(3)), Var(4)), Var(5)).calc()}")
}