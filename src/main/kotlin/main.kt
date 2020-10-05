@file: JvmName("main")

fun quicksort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val midElement = list[list.size / 2]
    return quicksort(list.filter { it < midElement }) +
            list.filter { it == midElement } +
            quicksort(list.filter { it > midElement })
}

fun <T> reverse(list: List<T>): List<T> =
    list.foldRight(listOf(), { nextElement, currentResult ->
        currentResult + nextElement
    })

fun <T> filterByFold(list: List<T>, function: (T) -> Boolean): List<T> =
    list.fold(listOf(), { currentResult, nextElement ->
        if (function(nextElement)) currentResult + nextElement
        else currentResult
    })

fun <T> filterByFoldRight(list: List<T>, function: (T) -> Boolean): List<T> =
    list.foldRight(listOf(), { nextElement, currentResult ->
        if (function(nextElement)) listOf<T>() + nextElement + currentResult
        else currentResult
    })

fun lengths(list: List<String>): List<Int> =
    list.fold(listOf(), {currentResult, nextString ->
        currentResult + nextString.length
    })

fun sumsq(n: Int) = (1..n).map {it * it}.sum()

fun <T, R> List<T>.mapAccumL(initial: R, function: (R, T) -> Pair<R, T>): Pair<R, List<T>> =
    this.fold(Pair(initial, listOf()), {currentResult, nextElement ->
        Pair(function(currentResult.first, nextElement).first,
            currentResult.second + function(currentResult.first, nextElement).second
        )
    })

fun main() {

}