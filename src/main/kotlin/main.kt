@file: JvmName("main")

fun quickSort(arr: List<Int>): List<Int> {
    if (arr.size < 2) return arr
    val p = arr[arr.size / 2]
    val l = arr.filter { it < p }
    val m = arr.filter { it == p }
    val r = arr.filter { it > p }
    return quickSort(l) + m + quickSort(r)
}

fun reverse(arr: List<Int>): List<Int> {
    return arr.foldRight(listOf()) { item, ans -> ans.plus(item) }
}

fun myFilter(arr: List<Int>, expr: (Int) -> Boolean): List<Int> {
    return arr.fold(listOf()) { ans, item -> if (expr(item)) ans.plus(item) else ans }
}

fun myFilterRight(arr: List<Int>, expr: (Int) -> Boolean): List<Int> {
    return arr.foldRight(listOf()) { item, ans -> if (expr(item)) ans.plus(item) else ans }
}

fun lengths(arr: List<String>): List<Int> {
    return List(arr.size) { i -> arr[i].length }
}

fun sumsq(n: Int): Int {
    return (1..n).map { i -> i * i}.sum()
}

fun List<Int>.mapAccumL(acc: Int, function: (Int, Int) -> Pair<Int, Int>): Pair<Int, List<Int>> {
    return if (this.isEmpty()) acc to listOf() else function(this.dropLast(1).mapAccumL(acc, function).first, this.last()).first to this.dropLast(1).mapAccumL(acc, function).second.plus(function(this.dropLast(1).mapAccumL(acc, function).first, this.last()).second)
}

fun main() {
    println(quickSort(listOf(1, 5, 8, 4, 3, 2, 7, 6)))
    println(reverse(listOf(2, 1, 3)))
    println(myFilter(listOf(1, 4, 2, 3)) { it > 2 })
    println(myFilterRight(listOf(1, 4, 2, 3)) { it > 2 })
    println(lengths(listOf("lol", "kek", "cheburek")))
    println(sumsq(10))
    println(listOf(9, 6, 3).mapAccumL(5) { x, y -> x to x * y })
    println(listOf(2, 4, 8).mapAccumL(5) { x, y -> x + y to x * y })
    println(listOf(2, 4, 8).mapAccumL(5) { x, y -> x + y to y })
    println(listOf(2, 4, 8).mapAccumL(5) { x, y -> y to y })
    println(listOf(2, 4, 8).mapAccumL(5) { x, y -> x to x })
}