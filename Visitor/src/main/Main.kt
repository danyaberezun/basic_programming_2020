package program

interface Node {
    fun accept(visitor: PrintVisitor): String
}

class Variable(val value: Int) : Node {
    override fun accept(visitor: PrintVisitor) = visitor.visit(this)
}

class Multiplication(val first: Node, val second: Node) : Node {
    override fun accept(visitor: PrintVisitor) = visitor.visit(this)
}

class Addition(val first: Node, val second: Node) : Node {
    override fun accept(visitor: PrintVisitor) = visitor.visit(this)
}

class PrintVisitor {
    fun visit(node: Variable): String {
        return node.value.toString()
    }
    fun visit(node: Multiplication): String {
        return "(${node.first.accept(PrintVisitor())} * ${node.second.accept(PrintVisitor())})"
    }
    fun visit(node: Addition): String {
        return "(${node.first.accept(PrintVisitor())} + ${node.second.accept(PrintVisitor())})"
    }
}

fun expression1(): Node {
    val a = Variable(10)
    val exp = a
    return exp
}

fun expression2(): Node {
    val a = Variable(23)
    val exp = Addition(Multiplication(a, a), Addition(a, a))
    return exp
}

fun expression3(): Node {
    val a = Variable(10)
    val b = Variable(20)
    val c = Variable(5)
    val d = Variable(6)
    val exp = Multiplication(Addition(Multiplication(a, b), Addition(c, d)), a)
    return exp
}

fun main() {
    expression3().accept(PrintVisitor())
}