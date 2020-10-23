package main

class PrintVisitor {
    fun visit(node: Multiply): String {
        val left = if(node.left is Sum) "(${node.left.accept(PrintVisitor())})" else node.left.accept(PrintVisitor())
        val right = if(node.right is Sum) "(${node.right.accept(PrintVisitor())})" else node.right.accept(PrintVisitor())
        return "$left * $right"
    }
    fun visit(node: Sum): String {
        val left = node.left.accept(PrintVisitor())
        val right = node.right.accept(PrintVisitor())
        return "$left + $right"
    }
    fun visit(node: Variable): String {
        return node.data.toString()
    }
}