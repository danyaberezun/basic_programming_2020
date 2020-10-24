interface Node {
    fun accept(printVisitor: PrintVisitor): String
    fun accept(calculateVisitor: CalculateVisitor): Int
}

class PrintVisitor {
    fun visit(node: Variable): String {
        return node.value.toString()
    }
    fun visit(node: Multiplication): String {
        return "(" + node.firstMultiplier.accept(PrintVisitor()) + " * " + node.secondMultiplier.accept(PrintVisitor()) + ")"
    }
    fun visit(node: Addition): String {
        return "(" + node.firstTerm.accept(PrintVisitor()) + " + " + node.secondTerm.accept(PrintVisitor()) + ")"
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

class Variable(val value: Int) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
}

class Multiplication(val firstMultiplier: Node, val secondMultiplier: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
}

class Addition(val firstTerm: Node, val secondTerm: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
    override fun accept(calculateVisitor: CalculateVisitor): Int {
        return calculateVisitor.visit(this)
    }
}

fun buildExp(): Node {
    val var1 = Variable(1)
    val var2 = Variable(2)
    val var3 = Variable(3)
    val sum12 = Addition(var1, var2)
    return Multiplication(sum12, var3)
}

fun main() {
    println(buildExp().accept(PrintVisitor()))
    println(buildExp().accept(CalculateVisitor()))
}