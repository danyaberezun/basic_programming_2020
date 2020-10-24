interface Expression {
    fun<T> accept(visitor: Visitor<T>): T
}

class Literal(val value: Int): Expression {
    override fun<T> accept(visitor: Visitor<T>) = visitor.visit(this)
}

class Sum(val left: Expression, val right: Expression): Expression {
    override fun<T> accept(visitor: Visitor<T>) = visitor.visit(this)
}

class Multiply(val left: Expression, val right: Expression): Expression {
    override fun<T> accept(visitor: Visitor<T>) = visitor.visit(this)
}