package main

class CalculateVisitor {
    fun visit(node: Multiply): Int {
        return node.left.accept(CalculateVisitor()) * node.right.accept(CalculateVisitor())
    }
    fun visit(node: Sum): Int{
        return node.left.accept(CalculateVisitor()) + node.right.accept(CalculateVisitor())
    }
    fun visit(node: Variable): Int{
        return node.data
    }
}