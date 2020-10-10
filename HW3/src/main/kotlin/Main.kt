@file:JvmName("Main")

fun main() {
    val list = mutableListOf(1, 5, 2, 4, 3, 7, 6, 2)
    val list1 = mutableListOf(1, 5, 2, 4, 3, 7, 6, 2)
    val list2 = mutableListOf("word", "new", "abstract")

    quickSort(list, 0, list.lastIndex)
    println(list)

    sumsq(4)

    println(lengths(list2))

    a2(list1)


}

fun List<Int>.mapAccumL() {
//TODO
}


fun lengths(list: MutableList<String>): List<Int> {
    return list.map { it.length }

}

//5
fun sumsq(n: Int) {
    val t = (1..n).map { it * it }

    println(t.fold(0) { total, next -> total + next })
}


//2
fun a2(list: MutableList<Int>) {
    list.reverse()
    print(list)
}


//1.quickSort
fun partition(list: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = list[high]
    var i = (low - 1)

    for (j in low until high) {
        if (list[j] < pivot) {
            i++
            val t = list[i]
            list[i] = list[j]
            list[j] = t
        }
    }
    val t = list[i + 1]
    list[i + 1] = list[high]
    list[high] = t
    return (i + 1);
}

fun quickSort(list: MutableList<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(list, low, high);

        quickSort(list, low, pi - 1);
        quickSort(list, pi + 1, high);
    }
}
