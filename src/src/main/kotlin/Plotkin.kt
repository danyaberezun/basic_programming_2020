import java.io.BufferedReader
import java.io.FileReader

typealias Instruction = Pair<Int, List<String>>

fun readInstructions(): List<Instruction> {
    val fileReader: BufferedReader?
    fileReader = BufferedReader(FileReader("dataPlotkin/input.txt"))
    val result = mutableListOf<Instruction>()
    fileReader.forEachLine {
        val splitLine = it.split(' ').filter { str -> str != "" }
        when (splitLine[0]) {
            "inc" -> result.add(Pair(1, listOf(splitLine[1])))
            "dec" -> result.add(Pair(2, listOf(splitLine[1])))
            "zero" -> result.add(Pair(3, splitLine.subList(1, splitLine.count())))
            "stop" -> result.add(Pair(0, listOf()))
        }
    }
    return result
}

fun nameToNumber(name: String): Int {
    return name[0] - 'x'
}

fun increment(name: String, variables: MutableList<Int>): MutableList<Int> {
    variables[nameToNumber(name)] += 1
    return variables
}

fun decrement(name: String, variables: MutableList<Int>): MutableList<Int> {
    if (variables[nameToNumber(name)] > 0)
        variables[nameToNumber(name)] -= 1
    return variables
}

fun zero(variables: MutableList<Int>, name: String, ifTrue: Int, ifFalse: Int): Int {
    return if (variables[nameToNumber(name)] == 0) ifTrue else ifFalse
}

fun implement(initial: Int, instructions: List<Instruction>): Int {
    var variables = mutableListOf<Int>(initial, 0, 0) // variables[0] - x, variables[1] - y, variables[2] - z
    var index = 0
    while (index < instructions.count()) {
        var instruction = instructions[index]
        when (instruction.first) {
            0 -> return variables[1]
            1 -> {
                variables = increment(instruction.second[0], variables)
                index += 1
            }
            2 -> {
                variables = decrement(instruction.second[0], variables)
                index += 1
            }
            3 -> {
                index = zero(variables, instruction.second[0], instruction.second[1].toInt(), instruction.second[3].toInt())
            }
        }
    }
    return variables[1]
}


fun main() {
    println("Input initial value:")
    val initial = readLine()!!.toInt()
    println(implement(initial, readInstructions()))
}