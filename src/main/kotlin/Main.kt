package funqsort

fun quicksort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val pivot: Int = list.last()
    val left: List<Int> = list.filter { it <= pivot }
    val center: List<Int> = list.filter { it == pivot }
    val right: List<Int> = list.filter { it > pivot }
    val result: List<Int> = quicksort(left) + center + quicksort(right)
    return result
}

fun reverse(list: List<Int>): List<Int> {
    return list.foldRight(listOf()) { element, reversedList -> reversedList + element }
}

fun filter(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return list.fold(
        listOf(),
        { filteredList, element -> if (predicate(element)) filteredList + element else filteredList })
}

fun filterRight(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return list.foldRight(
        listOf(),
        { element, filteredList -> if (predicate(element)) filteredList + element else filteredList })
}

fun lengths(strings: List<String>): List<Int> {
    return strings.map { it.length }
}

fun sumsq(n: Int): List<Int> {
    return (1..n).map { it * it }
}

fun <T, R, V> List<R>.mapAccumL(f: (T, R) -> Pair<T, V>, initial: T): Pair<T, List<V>> {
    val result = Pair(initial, emptyList<V>())
    return fold(result) { current, it -> Pair(f(current.first, it).first, current.second + f(current.first, it).second) }
}
