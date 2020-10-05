fun quickSort(list: List<Int>): List<Int> {
    if (list.size <= 1)
        return list
    // Берем первый элемент за опорный и разбиваем массив на три части
    // первую и последнюю части сортим еще раз
    return quickSort(list.filter { it < list.first() }) + list.filter { it == list.first() } + quickSort(list.filter { it > list.first() })

}

fun reverse(list: List<Int>): List<Int> {
    return list.foldRight(listOf()) { item, revList -> revList + item }
}

fun filterWithFold(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return list.fold(listOf()) {answer, item -> if (predicate(item)) (answer + item) else answer}
}

fun filterWithFoldRight(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return list.foldRight(listOf()) {item, answer -> if (predicate(item)) answer + item else answer}
}

fun lengths(list: List<String>): List<Int> {
    return list.fold(listOf()) {answer, item -> answer + item.length}
}

fun sumSquares(n: Int): Int {
    return IntArray(n){it + 1}.map{it * it}.sum()
}

fun mapAccumulation(x: Int, list: List<Int>, func: (Int, Int) -> Pair<Int, Int>): Pair<Int, List<Int>> {
    val firstStep = list.fold(listOf(Pair(x, 0))) { answer, it -> answer + func(answer.last().first, it) }
    val secondStep = (1..list.size).map { firstStep[it].second }
    return Pair(firstStep.last().first, secondStep)
}

fun main() {}

