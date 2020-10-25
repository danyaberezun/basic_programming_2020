package main

interface Node {
    fun <T>accept(v: Visitor<T>): T
}

class Multiply(l: Node, r: Node) : Node {
    override fun <T>accept(v: Visitor<T>) = v.visit(this)
    val left = l
    val right = r
}

class Sum(l: Node, r: Node) : Node {
    override fun <T>accept(v: Visitor<T>) = v.visit(this)
    val left = l
    val right = r
}

class Variable(d: Int) : Node {
    override fun <T>accept(v: Visitor<T>) = v.visit(this)
    val data = d
}