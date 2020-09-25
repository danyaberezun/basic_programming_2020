import java.lang.Exception
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val n: Int? = try {
        args[0].toInt()
    } catch (e: Exception) {
        null
    }
    val fibSeq = createSequence(n)
    print(fibSeq?.joinToString(", "))
}

fun createSequence(n: Int?): List<Int>? {
    return if (n != null) {
        generateSequence(Pair(1, 1), { Pair(it.second, it.first + it.second) }).map {it.first}.take(n).toList()
    } else {
        null
    }
}