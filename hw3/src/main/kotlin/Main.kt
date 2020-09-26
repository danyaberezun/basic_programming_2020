fun <T : Comparable<T>> quicksort(list: List<T>): List<T> {
    if (list.size <= 1)
        return list
    val middle = list.random()
    val (equal, notEqual) = list.partition { it == middle }
    val (less, greater) = notEqual.partition { it < middle }
    return quicksort(less) + equal + quicksort(greater)
}

fun <T> reverse(list: List<T>): List<T> = list.foldRight(listOf()) { element, current -> current + element }

fun <T> filter(list: List<T>, f: (T) -> Boolean): List<T> = list.fold(listOf()) { current, element ->
    if (f(element))
        current + element
    else
        current
}
fun <T> filterRight(list: List<T>, f: (T) -> Boolean): List<T> = list.foldRight(listOf()) { element, current ->
    if (f(element))
        listOf(element) + current
    else
        current
}
fun lengths(strings: List<String>) = strings.map {it.length}

fun main() {
    println(quicksort(listOf(1, 9, 2, 7, 4, 2, 3)))
    println(reverse(listOf(1, 9, 4)))
    println(reverse(listOf<Int>()))
    println(filter(listOf(2, 5, 4, 1, 80, 2)) { it % 2 == 0 })
    println(filterRight(listOf(2, 5, 4, 1, 80, 2)) { it % 2 == 0 })
    println(lengths(listOf("123", "", "aa")))
}
