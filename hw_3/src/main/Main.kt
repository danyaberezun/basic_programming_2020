package functional

fun quicksort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val element = list.random()
    val left: List<Int> = list.filter { it < element }
    val mid: List<Int> = list.filter { it == element }
    val right: List<Int> = list.filter { it > element }
    val res: List<Int> = quicksort(left) + mid + quicksort(right)
    return res
}

fun reverse(list: List<Int>): List<Int> {
    return list.foldRight(
        listOf(),
        { element, revList -> revList + element }
    )
}

fun filter_withFold(list: List<Int>, function: (Int) -> Boolean): List<Int> {
    return list.fold(
        listOf(),
        { filteredList, element -> if (function(element)) filteredList + element else filteredList }
    )
}

fun filter_withFoldRight(list: List<Int>, function: (Int) -> Boolean): List<Int> {
    return reverse(list.foldRight(
        listOf(),
        { element, filteredList -> if (function(element)) filteredList + element else filteredList }
    ))
}

fun lengths(listOfStrings: List<String>): List<Int> {
    return listOfStrings.map { it.length }
}

fun sumsq(n: Int): Int {
    val array = 1..n
    return array.map { it * it }.sum()
}

fun <A, B, C> List<B>.mapAccumL(init_elem: A, function: (A, B) -> Pair<A, C>): Pair<A, List<C>> {
    return fold(Pair(init_elem, emptyList<C>()))
        { current_result, it -> Pair( function(current_result.first, it).first,
                                      current_result.second + function(current_result.first, it).second) }
}

fun main() {
    println(quicksort(listOf(20, 9, 8, 11, 4, 2, 4)))
    println(reverse(listOf(1, 2, 3, 4, 5)))

    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(filter_withFold(listOf(20, 9, 8, 11, 4, 2, 4), isEven))
    println(filter_withFoldRight(listOf(20, 9, 8, 11, 4, 2, 4), isEven))

    println(lengths(listOf("aaa ", "", "5tgfihjb")))
    println(sumsq(10))
    println(listOf(9, 6, 3).mapAccumL(5) { x, y -> Pair(x, x * y)})
}