import kotlin.random.Random

fun<T: Comparable<T>> quicksort(list: List<T>): List<T> {
    if (list.size <= 1)
        return list
    val middle = list[Random.nextInt(list.size)]
    val (equal, notEqual) = list.partition { it == middle }
    val (less, greater) = notEqual.partition { it < middle }
    return quicksort(less) + equal + quicksort(greater)
}

fun main() {
    println(quicksort(listOf(1, 9, 2, 7, 4, 2, 3)))
}