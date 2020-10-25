package main

class ExpandVisitor: Visitor<List<String>> {
    override fun visit(node: Variable): List<String> {
        return listOf(node.data.toString())
    }
    override fun visit(node: Sum): List<String> {
        return node.left.accept(ExpandVisitor()) + node.right.accept(ExpandVisitor())
    }
    override fun visit(node: Multiply): List<String>  {
        val left = node.left.accept(ExpandVisitor())
        val right = node.right.accept(ExpandVisitor())
        return left.fold(mutableListOf<String>()) { list, leftElement ->
            list.addAll(right.map { rightElement -> "$leftElement * $rightElement" })
            list
        }
    }
}