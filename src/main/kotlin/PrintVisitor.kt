class PrintVisitor: Visitor<String> {
    override fun visit(node: Literal): String {
        return node.value.toString()
    }
    override fun visit(node: Sum): String {
        return "${node.left.accept(PrintVisitor())} + ${node.right.accept(PrintVisitor())}"
    }
    override fun visit(node: Multiply): String {
        val resultForLeftChild = when(node.left) {
            is Sum -> "(${node.left.accept(PrintVisitor())})"
            else -> node.left.accept(PrintVisitor())
        }
        val resultForRightChild = when(node.right) {
            is Sum -> "(${node.right.accept(PrintVisitor())})"
            else -> node.right.accept(PrintVisitor())
        }
        return "$resultForLeftChild * $resultForRightChild"
    }
}

fun printExpression(node: Expression): String {
    return node.accept(PrintVisitor())
}