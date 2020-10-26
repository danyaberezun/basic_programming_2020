interface Visitor<T> {
    fun visit(node: Literal): T
    fun visit(node: Addition): T
    fun visit(node: Multiplication): T
}

interface Node {
    fun <T> accept(visitor: Visitor<T>): T
}

class Literal(val number: Int) : Node {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}

class Multiplication(val left: Node, val right: Node) : Node {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}

class Addition(val left: Node, val right: Node) : Node {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}

class PrintVisitor : Visitor<Unit> {
    override fun visit(node: Literal) {
        print(node.number)
    }

    override fun visit(node: Addition) {
        print("(")
        node.left.accept(this)
        print(" + ")
        node.right.accept(this)
        print(")")
    }

    override fun visit(node: Multiplication) {
        print("(")
        node.left.accept(this)
        print(" * ")
        node.right.accept(this)
        print(")")
    }
}

class CalculateVisitor : Visitor<Int> {
    override fun visit(node: Literal): Int {
        return node.number
    }

    override fun visit(node: Addition): Int {
        return node.left.accept(this) + node.right.accept(this)
    }

    override fun visit(node: Multiplication): Int {
        return node.left.accept(this) * node.right.accept(this)
    }
}

class ExpandVisitor : Visitor<Node> {
    override fun visit(node: Literal): Node {
        return node
    }

    override fun visit(node: Addition): Node {
        return Addition(node.left.accept(this), node.right.accept(this))
    }

    override fun visit(node: Multiplication): Node {
        if (node.left is Addition) {
            return Addition(
                Multiplication(node.right, node.left.left.accept(this)),
                Multiplication(node.right, node.left.right.accept(this))
            )
        }

        if (node.right is Addition) {
            return Addition(
                Multiplication(node.left, node.right.left).accept(this),
                Multiplication(node.left, node.right.right).accept(this)
            )
        }

        return Multiplication(node.left.accept(this), node.right.accept(this))

    }
}

fun main() {
    val root: Multiplication = Multiplication(
        Literal(5),
        Addition(Literal(3), Literal(2))
    )

    println(root.accept(CalculateVisitor()))

    root.accept(PrintVisitor())
    println()
    root.accept(ExpandVisitor()).accept(PrintVisitor())
}