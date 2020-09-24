import java.io.File
import java.lang.Exception

fun fibonacci(n: Int): Long {
    if (n == 0)
        return 0
    var first = 0L
    var second = 1L
    for (i in 2..n) {
        val next = first + second
        first = second
        second = next
    }
    return second
}

class InvalidInputException(message: String) : Exception(message)

fun readFile(inputFile: String): List<Int> {
    val file = File(inputFile)
    if (!file.exists())
        throw InvalidInputException("$inputFile: no such file")
    val numbers = file.readLines().filter { it.isNotEmpty() }.map { it.toIntOrNull() }
    val validNumbers = numbers.filterNotNull()
    if (validNumbers.size < numbers.size)
        throw InvalidInputException("Input is not a list of numbers")
    return validNumbers
}

fun writeFibonacci(outputFile: String, numbers: List<Int>) {
    File(outputFile).writeText(numbers.joinToString("\n") { fibonacci(it).toString() })
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        throw InvalidInputException("No input file")
    }
    val file = args[0]
    val numbers = readFile(file)
    writeFibonacci("$file.out", numbers)
}