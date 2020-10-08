fun main() {
    println(quicksort(mutableListOf(3, 2, 1, 5, 10, 6, 9, 8)))
    println(reverse(listOf(3, 2, 1, 5)))
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