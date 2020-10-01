import java.util.*

fun quickSort(listToSort: List<Int>): List<Int> {
    if (listToSort.size <= 1) return listToSort

    val pivotPoint = listToSort.first()
    val smallerThanPivot = listToSort.filter { it < pivotPoint }
    val equalToPivot = listToSort.filter { it == pivotPoint }
    val largerThanPivot = listToSort.filter { it > pivotPoint }
    return quickSort(smallerThanPivot) + equalToPivot + quickSort(largerThanPivot)
}

fun <T> reverse(listToReverse: List<T>) = listToReverse.foldRight(mutableListOf<T>() as List<T>) { item, list ->
    list as MutableList
    list.add(item)
    list
}

fun <T> filterViaFold(listToFilter: List<T>, filterFunction: (T) -> Boolean) =
    listToFilter.fold(mutableListOf<T>()) { list, item ->
        if (filterFunction(item)) list.add(item)
        list
    }

fun <T> filterViaFoldRight(listToFilter: List<T>, filterFunction: (T) -> Boolean) =
    listToFilter.foldRight(LinkedList<T>() as List<T>) { item, list ->
        list as LinkedList<T>
        if (filterFunction(item))
            list.addFirst(item)
        list
    }

fun lengths(listOfStrings: List<String>) = listOfStrings.fold(mutableListOf<Int>() as List<Int>) { list, item ->
    list as MutableList
    list.add(item.length)
    list
}

fun sumsq(n: Int) = (1..n).map { it * it }.fold(0) { sum, number -> sum + number }

fun <T, R> List<R>.mapAccumL(
    initial: T,
    functionToApply: (T, R) -> Pair<T, R>
) = this.fold(Pair(initial, mutableListOf<R>() as List<R>)) { result, item ->
    val functionOut = functionToApply(result.first, item)
    (result.second as MutableList<R>).add(functionOut.second)
    Pair(functionOut.first, result.second)
}

fun main() {}