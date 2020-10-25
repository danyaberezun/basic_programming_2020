package main

interface Visitor <T> {
    fun visit(node: Variable): T
    fun visit(node: Sum): T
    fun visit(node: Multiply): T
}

fun printExpression(node: Node): String {
    return node.accept(PrintVisitor())
}

fun calculateExpression(node: Node): Int {
    return node.accept(CalculateVisitor())
}

fun expandExpression(node: Node): String {
    return node.accept(ExpandVisitor()).joinToString(" + ")
}

fun main() {
}