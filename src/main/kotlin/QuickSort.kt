fun reverse(array: List<Int>): List<Int> {
    return array.foldRight(emptyList(), { element, newArray -> newArray.plus(element) })
}

fun filter(array: List<Int>, predicate: (Int) -> (Boolean)): List<Int> {
    return array.fold(emptyList(), { newArray, element ->
        if (predicate(element)) newArray.plus(element) else newArray })
}

fun lengths(array: List<List<Int>>): List<Int> {
    return array.fold(emptyList(), { newArray, element -> newArray.plus(element.size) })
}

fun sumsq(n: Int): Int {
    return (1..n).map { x -> x * x }.sum()
}