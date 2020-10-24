interface Node {
    fun accept(printVisitor: PrintVisitor): String
    fun accept(calculateVisitor: CalculateVisitor): Int
    fun accept(expandVisitor: ExpandVisitor): List<String>
}

class PrintVisitor {
    fun visit(node: Variable): String {
        return "${node.value}"
    }
    fun visit(node: Multiplication): String {
        val firstMultiplier = if (node.firstMultiplier is Addition) {
            "(${node.firstMultiplier.accept(PrintVisitor())})"
        } else {
            node.firstMultiplier.accept(PrintVisitor())
        }
        val secondMultiplier = if (node.secondMultiplier is Addition) {
            "(${node.secondMultiplier.accept(PrintVisitor())})"
        } else {
            node.secondMultiplier.accept(PrintVisitor())
        }
        return "$firstMultiplier * $secondMultiplier"
    }
    fun visit(node: Addition): String {
        return "${node.firstTerm.accept(PrintVisitor())} + ${node.secondTerm.accept(PrintVisitor())}"
    }
}

class CalculateVisitor {
    fun visit(node: Variable): Int {
        return node.value
    }
    fun visit(node: Multiplication): Int {
        return node.firstMultiplier.accept(CalculateVisitor()) * node.secondMultiplier.accept(CalculateVisitor())
    }
    fun visit(node: Addition): Int {
        return node.firstTerm.accept(CalculateVisitor()) + node.secondTerm.accept(CalculateVisitor())
    }
}

class ExpandVisitor {
    fun visit(node: Variable): List<String> {
        return listOf(node.value.toString())
    }
    fun visit(node: Multiplication): List<String> {
        val listForFirst = node.firstMultiplier.accept(ExpandVisitor())
        val listForSecond = node.secondMultiplier.accept(ExpandVisitor())
        return listForFirst.fold(listOf(), { curList, curString -> curList + listForSecond.map {"$curString * $it"} } )
    }
    fun visit(node: Addition): List<String> {
        return node.firstTerm.accept(ExpandVisitor()) + node.secondTerm.accept(ExpandVisitor())
    }
}

class Variable(val value: Int) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
    override fun accept(expandVisitor: ExpandVisitor): List<String> {
        return expandVisitor.visit(this)
    }
}

class Multiplication(val firstMultiplier: Node, val secondMultiplier: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
    override fun accept(expandVisitor: ExpandVisitor): List<String> {
        return expandVisitor.visit(this)
    }
}

class Addition(val firstTerm: Node, val secondTerm: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
    override fun accept(expandVisitor: ExpandVisitor): List<String> {
        return expandVisitor.visit(this)
    }
}

// (1 + 2) * 3
fun buildExpressionForTest1(): Node {
    val var1 = Variable(1)
    val var2 = Variable(2)
    val var3 = Variable(3)
    val sum1 = Addition(var1, var2)
    return Multiplication(sum1, var3)
}

// (1 + 2) * 3 * 5 * 5
fun buildExpressionForTest2(): Node {
    val exp1 = buildExpressionForTest1()
    val var1 = Variable(5)
    val mult1 = Multiplication(exp1, var1)
    return Multiplication(mult1, var1)
}

// 25 * (107 + 23) * (9 + 9) + 2 * ((1 + 1) * 2 + 1 + 1) * 7
fun buildExpressionForTest3(): Node {
    val var1 = Variable(25)
    val var2 = Variable(107)
    val var3 = Variable(23)
    val var4 = Variable(9)
    val var5 = Variable(2)
    val var6 = Variable(1)
    val var7 = Variable(7)
    val sum1 = Addition(var2, var3)
    val sum2 = Addition(var4, var4)
    val sum3 = Addition(var6, var6)
    val mult1 = Multiplication(var1, sum1)
    val mult2 = Multiplication(mult1, sum2)
    val mult3 = Multiplication(sum3, var5)
    val sum4 = Addition(mult3, var6)
    val sum5 = Addition(sum4, var6)
    val mult4 = Multiplication(var5, sum5)
    val mult5 = Multiplication(mult4, var7)
    return Addition(mult2, mult5)
}

fun runPrintVisitor(expression: Node): String {
    return expression.accept(PrintVisitor())
}

fun runCalculateVisitor(expression: Node): Int {
    return expression.accept(CalculateVisitor())
}

fun runExpandVisitor(expression: Node): String {
    return expression.accept(ExpandVisitor()).joinToString(" + ")
}

fun main() {
    println(runPrintVisitor(buildExpressionForTest1()))
    println(runCalculateVisitor(buildExpressionForTest1()))
    println(runExpandVisitor(buildExpressionForTest1()))
}