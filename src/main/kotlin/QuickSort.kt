fun main() {
    println(quickSort(listOf(3, 1, 7, 23, 12, 9, 4)))
    println(reverse(listOf(3, 1, 7, 23, 12, 9, 4)))
    println(filter(listOf(3, 1, 7, 23, 12, 9, 4)) { x -> x % 2 == 0 })
    println(lengths(listOf(listOf(3, 1, 7, 23, 12, 9, 4), listOf(1, 2), emptyList())))
    println(sumsq(5))
    println(listOf(3, 1, 7, 23, 11, 9, 4).mapAccumL("abc") {
        init, el -> Pair(init + el.toString(), el + init.length)
    })
}

fun quickSort(array: List<Int>): List<Int> {
    if (array.isEmpty()) return emptyList()
    val pivot = array.random()
    return quickSort(array.filter { it < pivot }) + pivot + quickSort(array.filter { it > pivot })
}

fun reverse(array: List<Int>): List<Int> {
    return array.foldRight(emptyList(), { element, newArray -> newArray + element })
}

fun filter(array: List<Int>, predicate: (Int) -> (Boolean)): List<Int> {
    return array.fold(emptyList(), { newArray, element ->
        if (predicate(element)) newArray + element else newArray })
}

fun lengths(array: List<List<Int>>): List<Int> {
    return array.fold(emptyList(), { newArray, element -> newArray + element.size })
}

fun sumsq(n: Int): Int {
    return (1..n).map { x -> x * x }.sum()
}

fun <T, R>List<T>.mapAccumL(initial: R, operation: (R, T) -> (Pair<R, T>)): Pair<R, List<T>> {
    return this.fold(Pair(initial, emptyList()), {
        accumulator, list -> Pair(operation(accumulator.first, list).first,
                                  accumulator.second + operation(accumulator.first, list).second)
    } )
}