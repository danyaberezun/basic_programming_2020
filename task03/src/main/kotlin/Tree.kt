package main

interface Node {
    fun accept(v: CalculateVisitor): Int
    fun accept(v: PrintVisitor): String
    fun accept(v: ExpandVisitor): List<String>
}

class Multiply(l: Node, r: Node) : Node {
    override fun accept(v: CalculateVisitor) = v.visit(this)
    override fun accept(v: PrintVisitor) = v.visit(this)
    override fun accept(v: ExpandVisitor) = v.visit(this)
    var left = l
    var right = r
}

class Sum(l: Node, r: Node) : Node {
    override fun accept(v: CalculateVisitor) = v.visit(this)
    override fun accept(v: PrintVisitor) = v.visit(this)
    override fun accept(v: ExpandVisitor) = v.visit(this)
    val left = l
    val right = r
}

class Variable(d: Int) : Node {
    override fun accept(v: CalculateVisitor) = v.visit(this)
    override fun accept(v: PrintVisitor) = v.visit(this)
    override fun accept(v: ExpandVisitor) = v.visit(this)
    val data = d
}