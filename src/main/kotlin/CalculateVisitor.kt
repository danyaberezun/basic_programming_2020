class CalculateVisitor: Visitor<Int> {
    override fun visit(node: Literal): Int {
        return node.value
    }
    override fun visit(node: Sum): Int {
        return node.left.accept(CalculateVisitor()) + node.right.accept(CalculateVisitor())
    }
    override fun visit(node: Multiply): Int {
        return node.left.accept(CalculateVisitor()) * node.right.accept(CalculateVisitor())
    }
}

fun calculateExpression(node: Expression): Int {
    return node.accept(CalculateVisitor())
}