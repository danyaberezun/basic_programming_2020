fun main() {
    println(quicksort(mutableListOf(3, 2, 1, 5, 10, 6, 9, 8)))
    println(reverse(listOf(3, 2, 1, 5)))
    println(filter(listOf(1, 2, 3, 4)) { it>2 })
    println(filterWithFoldR(listOf(1, 2, 3, 4, 5)) {it >= 2})
    println(lengths(listOf("123", "12", "1")))
    println(sumsq(3))
}

fun quicksort(arr: List<Int>): List<Int> {
    if (arr.isEmpty()) {
        return arr
    }

    val pivot = arr[(0 + arr.size - 1) / 2]

    return quicksort(arr.filter { it < pivot }) + arr.filter { it == pivot } + quicksort(arr.filter { it > pivot })

}

fun <T>reverse(arr: List<T>): List<T> {
    return arr.foldRight(listOf<T>()) { current, acc ->  acc + current }
}

fun <T>filter(arr: List<T>, filterFun: (element: T) -> Boolean): List<T> {
    return arr.fold(listOf<T>()) lit@{ acc, current ->

        return@lit if (filterFun(current)) {
            acc + listOf(current)
        } else {
            acc
        }
    }
}

fun <T> filterWithFoldR(arr: List<T>, filterFun: (element: T) -> Boolean) : List<T> {
    return arr.foldRight(listOf<T>()) lit@{ current, acc ->
        return@lit if (filterFun(current)) {
            listOf(current) + acc
        } else {
            acc
        }
    }
}

fun lengths(strings: List<String>): List<Int> {
    return strings.map { it.length }
}

fun sumsq(n: Int): Int {
    var sum: Int = 0
    (1..n).map {sum += it * it}
    return sum
}