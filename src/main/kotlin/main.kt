fun quickSort(arr: List<Int>) : List<Int> {
    if (arr.size <= 1)
        return arr
    val leftPart: List<Int> = arr.filter { it < arr.last() }
    val middlePart: List<Int> = arr.filter { it == arr.last() }
    val rightPart: List<Int> = arr.filter { it > arr.last() }
    return quickSort(leftPart) + middlePart + quickSort(rightPart)
}

fun reverse(arr: List<Int>) : List<Int> {
    return arr.foldRight(listOf()) { item, revArr -> revArr + item }
}

fun myFilterWithFold(arr: List<Int>, predicate: (Int) -> Boolean) : List<Int> {
    return arr.fold(listOf()) { answer, item -> if (predicate(item)) answer + item else answer }
}

fun myFilterWithFoldRight(arr: List<Int>, predicate: (Int) -> Boolean) : List<Int> {
    return arr.foldRight(listOf()) { item, answer -> if (predicate(item)) answer + item else answer }
}

fun lengths(arr: List<String>) : List<Int> {
    return arr.fold(listOf()) { answer, item -> answer + item.length }
}

fun sumSquares(n : Int) : Int {
    return IntArray(n) {it + 1}. map {it * it}. sum()
}

fun mapAccumulation(x : Int, arr: List<Int>, myFunction: (Int, Int) -> Pair<Int, Int>) : Pair<Int, List<Int>> {
    val firstStep = arr.fold(listOf(Pair(x, 0))) { ans, it -> ans + myFunction(ans.last().first, it) }
    val secondStep = (1..arr.size). map {firstStep[it].second}
    return Pair(firstStep.last().first, secondStep)
}

fun main() {}
