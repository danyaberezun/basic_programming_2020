@file: JvmName("main")

interface Expr {
    fun apply(v: PrintVisitor): String
    fun apply(v: CalculateVisitor): Int
}

class Var(x: Int) : Expr {
    val value = x

    override fun apply(v: PrintVisitor): String {
        return v.visit(this)
    }

    override fun apply(v: CalculateVisitor): Int {
        return v.visit(this)
    }
}

class Sum(a: Expr, b: Expr) : Expr {
    val left = a
    val right = b

    override fun apply(v: PrintVisitor): String {
        return v.visit(this)
    }

    override fun apply(v: CalculateVisitor): Int {
        return v.visit(this)
    }
}

class Mul(a: Expr, b: Expr) : Expr {
    val left = a
    val right = b

    override fun apply(v: PrintVisitor): String {
        return v.visit(this)
    }

    override fun apply(v: CalculateVisitor): Int {
        return v.visit(this)
    }
}

class PrintVisitor {
    fun visit(e: Var): String {
        return "${e.value}"
    }

    fun visit(e: Sum): String {
        return "(${e.left.apply(PrintVisitor())} + ${e.right.apply(PrintVisitor())})"
    }

    fun visit(e: Mul): String {
        return "${e.left.apply(PrintVisitor())} * ${e.right.apply(PrintVisitor())}"
    }
}

class CalculateVisitor {
    fun visit(e: Var): Int {
        return e.value
    }

    fun visit(e: Sum): Int {
        return e.left.apply(CalculateVisitor()) + e.right.apply(CalculateVisitor())
    }

    fun visit(e: Mul): Int {
        return e.left.apply(CalculateVisitor()) * e.right.apply(CalculateVisitor())
    }
}

fun main() {
    println("${Mul(Sum(Var(2), Var(3)), Var(4)).apply(PrintVisitor())} = ${Mul(Sum(Var(2), Var(3)), Var(4)).apply(CalculateVisitor())}")
    println("${Mul(Sum(Sum(Var(2), Var(2)), Mul(Sum(Mul(Var(2), Var(4)), Var(3)), Var(4))), Var(10)).apply(PrintVisitor())} = ${Mul(Sum(Sum(Var(2), Var(2)), Mul(Sum(Mul(Var(2), Var(4)), Var(3)), Var(4))), Var(10)).apply(CalculateVisitor())}")
    println("${Var(5).apply(PrintVisitor())} = ${Var(5).apply(CalculateVisitor())}")
    println("${Sum(Var(2), Var(3)).apply(PrintVisitor())} = ${Sum(Var(2), Var(3)).apply(CalculateVisitor())}")
    println("${Mul(Var(2), Var(2)).apply(PrintVisitor())} = ${Mul(Var(2), Var(2)).apply(CalculateVisitor())}")
    println("${Mul(Var(3), Sum(Var(4), Var(5))).apply(PrintVisitor())} = ${Mul(Var(3), Sum(Var(4), Var(5))).apply(CalculateVisitor())}")
    println("${Sum(Mul(Var(3), Var(3)), Mul(Var(4), Var(4))).apply(PrintVisitor())} = ${Sum(Mul(Var(3), Var(3)), Mul(Var(4), Var(4))).apply(CalculateVisitor())}")
    println("${Sum(Sum(Sum(Sum(Var(1), Var(2)), Var(3)), Var(4)), Var(5)).apply(PrintVisitor())} = ${Sum(Sum(Sum(Sum(Var(1), Var(2)), Var(3)), Var(4)), Var(5)).apply(CalculateVisitor())}")
}