package main

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