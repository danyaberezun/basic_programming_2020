interface Node {
    fun visit(printVisitor: PrintVisitor): String
    fun visit(calculateVisitor: CalculateVisitor): Int
}

class Number(val value: Int): Node {

    override fun visit(printVisitor: PrintVisitor) = printVisitor.visit(this)

    override fun visit(calculateVisitor: CalculateVisitor) = calculateVisitor.visit(this)
}

class Sum(val firstValue: Node, val secondValue: Node): Node {

    override fun visit(printVisitor: PrintVisitor) = printVisitor.visit(this)

    override fun visit(calculateVisitor: CalculateVisitor) = calculateVisitor.visit(this)
}

class Product(val firstValue: Node, val secondValue: Node): Node {

    override fun visit(printVisitor: PrintVisitor) = printVisitor.visit(this)

    override fun visit(calculateVisitor: CalculateVisitor) = calculateVisitor.visit(this)
}

class PrintVisitor {

    fun visit(node: Number) = "${node.value}"

    fun visit(node: Sum) = "(${node.firstValue.visit(PrintVisitor())} + ${node.secondValue.visit(PrintVisitor())})"

    fun visit(node: Product) = "(${node.firstValue.visit(PrintVisitor())} * ${node.secondValue.visit(PrintVisitor())})"
}

class CalculateVisitor {

    fun visit(node: Number) = node.value

    fun visit(node: Sum) = node.firstValue.visit(CalculateVisitor()) + node.secondValue.visit(CalculateVisitor())

    fun visit(node: Product) = node.firstValue.visit(CalculateVisitor()) * node.secondValue.visit(CalculateVisitor())
}

//(1930 * ((2 * 222) + 9))
fun expression(): Node {
    val firstNumber = Number(2)
    val secondNumber = Number(222)
    val thirdNumber = Number(9)
    val fourthValue = Number(1930)
    return Product(fourthValue, Sum(Product(firstNumber, secondNumber), thirdNumber))
}

fun main() {
    println(expression().visit(PrintVisitor()))
    println(expression().visit(CalculateVisitor()))
}