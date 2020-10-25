package main

class CalculateVisitor: Visitor<Int> {
    override fun visit(node: Multiply): Int {
        return node.left.accept(CalculateVisitor()) * node.right.accept(CalculateVisitor())
    }
    override fun visit(node: Sum): Int{
        return node.left.accept(CalculateVisitor()) + node.right.accept(CalculateVisitor())
    }
    override fun visit(node: Variable): Int{
        return node.data
    }
}