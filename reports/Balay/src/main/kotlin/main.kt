package hw3

fun quicksort(arr: List<Int>): List<Int> {
    if(arr.size <= 1)
        return arr
    val piv = arr.first()
    val arr1 = arr.filter {it < piv}
    val arr3 = arr.filter {it > piv}
    val arr2 = arr.filter {it == piv}
    return quicksort(arr1) + arr2 +  quicksort(arr3)
}

fun reverse(arr: List<Int>) = arr.foldRight(mutableListOf<Int>()) { item, list ->
    list.add(item)
    list
}

fun <T> filter(list: List<T>, f: (T) -> Boolean): List<T> {
    return list.fold(mutableListOf<T>()) {list, item ->
        if(f(item))
            list.add(item)
        list
    }
}

fun <T> filterR(list: List<T>, f: (T) -> Boolean): List<T> {
    return list.foldRight(mutableListOf<T>()) {item, list ->
        if(f(item))
            list.add(item)
        list
    }
}

fun lengths(list: List<String>) = list.fold(0) {sum, item -> item.length + sum}

fun sumsq(n: Int) = (1..n).map { it * it }.fold(0) {sum, it -> sum + it}

fun<G, T> List<T>.mapAccumL(
        initial: G,
        f: (G, T) -> Pair<G, T>
): Pair<G, List<T>> {
    var accumulator = initial
    val returnList = mutableListOf<T>()
    for (element in this) {
        val temp = f(accumulator, element)
        accumulator = temp.first
        returnList.add(temp.second)
    }
    return Pair(accumulator, returnList)
}

fun main() {
}