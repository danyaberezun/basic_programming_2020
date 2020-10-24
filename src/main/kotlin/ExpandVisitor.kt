class ExpandVisitor: Visitor<List<String>> {
    override fun visit(node: Literal): List<String> {
        return listOf(node.value.toString())
    }
    override fun visit(node: Sum): List<String> {
        return node.left.accept(ExpandVisitor()) + node.right.accept(ExpandVisitor())
    }
    override fun visit(node: Multiply): List<String> {
        val resultForLeftChild = node.left.accept(ExpandVisitor())
        val resultForRightChild = node.right.accept(ExpandVisitor())
        return resultForLeftChild.fold(mutableListOf()) {
            currentList, newLeftElement ->
            currentList.apply {
                addAll(resultForRightChild.map { rightElement -> "$newLeftElement * $rightElement"})
            }
        }
    }
}

fun expandExpression(node: Expression): String {
    return node.accept(ExpandVisitor()).joinToString(" + ")
}