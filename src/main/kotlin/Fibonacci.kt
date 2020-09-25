fun main() {
    val n: Int? = readLine()?.toInt()
    val fibSeq = createSequence(n)
    print(fibSeq)
}

fun createSequence(n: Int?): List<Int>? {
    return if (n != null) {
        generateSequence(Pair(1, 1), { Pair(it.second, it.first + it.second) }).map {it.first}.take(n).toList()
    } else {
        null
    }
}