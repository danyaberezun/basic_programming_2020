class Node(var key: String, var left: Node?, var right: Node?)

fun build(x: Int, list: List<String>) : Node? {
    if (x >= list.size)
        return null
    return Node(list[x], build(2 * x + 1, list), build(2 * x + 2, list))
}

fun printVisitor(node: Node?) : String {
    if (node == null)
        return ""
    var ans = "${printVisitor(node.left)}${node.key}${printVisitor(node.right)}"
    if ('+' in ans || '*' in ans)
        ans = "($ans)"
    return ans
}

fun calculateVisitor(node: Node) : Int {
    if (node.key == "+")
        return calculateVisitor(node.left!!) + calculateVisitor(node.right!!)
    if (node.key == "*")
        return calculateVisitor(node.left!!) * calculateVisitor(node.right!!)
    return node.key.toInt()
}

fun expandVisitor(node: Node) : String {
    if (node.key == "+")
        return "${expandVisitor(node.left!!)}+${expandVisitor(node.right!!)}"
    if (node.key == "*") {
        val leftPart = expandVisitor(node.left!!).split('+')
        val rightPart = expandVisitor(node.right!!).split('+')
        var ans = ""
        for (leftItem in leftPart)
            for (rightItem in rightPart)
                ans += "$leftItem*$rightItem+"
        return ans.substring(0, ans.length - 1)
    }
    return node.key
}

fun main() {
    val inputList = readLine().toString().split(" ").toList()
    val root = build(0, inputList)!!
    val expr = printVisitor(root)
    println(expr.substring(1, expr.length - 1))
    val value = calculateVisitor(root)
    println(value)
    val expressionWithoutBrackets = expandVisitor(root)
    println(expressionWithoutBrackets)
}

