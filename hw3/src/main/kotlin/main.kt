fun main() {
    println(quicksort(mutableListOf(3, 2, 1, 5, 10, 6, 9, 8)))
}

fun quicksort(arr: List<Int>): List<Int> {
    if (arr.isEmpty()) {
        return arr
    }

    val pivot = arr[(0 + arr.size - 1) / 2]

    return quicksort(arr.filter { it < pivot }) + arr.filter { it == pivot } + quicksort(arr.filter { it > pivot })

}

fun reverse() {

}