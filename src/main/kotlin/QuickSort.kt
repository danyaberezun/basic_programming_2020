fun quickSort(array: List<Int>): List<Int> {
    if (array.size <= 1) return array
    val randomElement = array.random()
    return quickSort(array.filter { it < randomElement }) + array.filter { it == randomElement } + quickSort(array.filter { it > randomElement })
}

fun reverse(array: List<Int>): List<Int> {
    return array.foldRight(listOf(), { curElement, curArray -> curArray + curElement })
}

fun filter(array: List<Int>, filterFunction: (Int) -> Boolean): List<Int> {
    return array.fold(listOf(), { curArray, curElement -> if (filterFunction(curElement)) curArray + curElement else curArray })
}

fun filterRight(array: List<Int>, filterFunction: (Int) -> Boolean): List<Int> {
    return reverse(array.foldRight(listOf(), { curElement, curArray -> if (filterFunction(curElement)) curArray + curElement else curArray }))
}

fun lengths(array: List<String>): List<Int> {
    return array.fold(listOf(), { curArray, curElement -> curArray + curElement.length })
}

fun sumsq(n: Int): Int {
    val arrayOfNumbers = 1..n
    val arrayOfNumbersSquares = arrayOfNumbers.map { it * it }
    return arrayOfNumbersSquares.sum()
}

fun <T, R>List<T>.mapAccumL(accum: R, appliedFunction: (R, T) -> Pair<R, T>): Pair<R, List<T>> {
    return this.fold(Pair(accum, listOf()), { curAnswer, curElement -> Pair(appliedFunction(curAnswer.first, curElement).first, curAnswer.second + appliedFunction(curAnswer.first, curElement).second) })
}

fun main() {
    println(quickSort(listOf(1, 3, 6, 5, 2, 4, 7)))
    println(reverse(listOf(1, 3, 6, 5, 2, 4, 7)))
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(filter(listOf(1, 3, 6, 5, 2, 4, 7), isEven))
    println(filterRight(listOf(1, 3, 6, 5, 2, 4, 7), isEven))
    println(lengths(listOf("aba", "", "a", "abracadabra", "pog", "kek", "nsivo")))
    println(sumsq(5))
    println(listOf(9, 6, 3).mapAccumL(5) { x, y -> Pair(x, x * y)})
}