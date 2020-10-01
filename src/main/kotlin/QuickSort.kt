fun reverse(array: List<Int>): List<Int> {
    return array.foldRight(emptyList(), { element, newArray -> newArray.plus(element) })
}