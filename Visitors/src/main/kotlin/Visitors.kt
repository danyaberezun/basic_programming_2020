interface Node {
    fun accept(printVisitor: PrintVisitor): String
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

class Variable(val value: Int) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
}

class Multiplication(val firstMultiplier: Node, val secondMultiplier: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
    }
}

class Addition(val firstTerm: Node, val secondTerm: Node) : Node {
    override fun accept(printVisitor: PrintVisitor): String {
        return printVisitor.visit(this)
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
}