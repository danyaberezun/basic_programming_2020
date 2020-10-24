interface Visitor<T> {
    fun visit(node: Literal): T
    fun visit(node: Sum): T
    fun visit(node: Multiply): T
}