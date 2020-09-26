fun <T : Comparable<T>> quicksort(list: List<T>): List<T> {
    if (list.size <= 1)
        return list
    val middle = list.random()
    val (equal, notEqual) = list.partition { it == middle }
    val (less, greater) = notEqual.partition { it < middle }
    return quicksort(less) + equal + quicksort(greater)
}

fun <T> reverse(list: List<T>): List<T> = list.foldRight(listOf()) { element, current -> current + element }

fun main() {
    println(quicksort(listOf(1, 9, 2, 7, 4, 2, 3)))
    println(reverse(listOf(1, 9, 4)))
    println(reverse(listOf<Int>()))
}
