package program

sealed class Node {
    abstract fun accept(v: PrintVisitor)
}

interface Visitor {
    fun visit(node: Variable)
    fun visit(node: Multiplication)
    fun visit(node: Addition)
}

class Variable(val value: Int) : Node() {
    override fun accept(printVisitor: PrintVisitor) = printVisitor.visit(this)
}

class Multiplication(val first: Node, val second: Node) : Node() {
    override fun accept(printVisitor: PrintVisitor) = printVisitor.visit(this)
}

class Addition(val first: Node, val second: Node) : Node() {
    override fun accept(printVisitor: PrintVisitor) = printVisitor.visit(this)
}

class PrintVisitor : Visitor {
    override fun visit(node: Variable) = println(node.value.toString())
    override fun visit(node: Multiplication) = println("(${node.first.accept(PrintVisitor())} * ${node.second.accept(PrintVisitor())})")
    override fun visit(node: Addition) = println("(${node.first.accept(PrintVisitor())} + ${node.second.accept(PrintVisitor())})")
}

fun expression(): Node {
    val a = Variable(10)
    val b = Variable(20)
    val c = Variable(5)
    val d = Variable(6)
    val exp = Addition(Multiplication(a, b), Multiplication(c, d))
    return exp
}

fun main() {
    expression().accept(PrintVisitor())
}