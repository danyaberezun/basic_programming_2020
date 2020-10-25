import java.io.BufferedReader
import java.io.FileReader

typealias Instruction = Pair<Int, List<String>>
typealias Range = Pair<Int, Int>

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
        val instruction = instructions[index]
        when (instruction.first) { // inc - 1, dec - 2, zero - 3, stop - 0
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

fun incrementRange(name: String, ranges: MutableList<Range>): MutableList<Range> {
    ranges[nameToNumber(name)] = Pair(ranges[nameToNumber(name)].first, ranges[nameToNumber(name)].second + 1)
    return ranges
}

fun decrementRange(name: String, ranges: MutableList<Range>): MutableList<Range> {
    if (ranges[nameToNumber(name)].first > 0)
    ranges[nameToNumber(name)] = Pair(ranges[nameToNumber(name)].first - 1, ranges[nameToNumber(name)].second)
    return ranges
}

fun inRange(value: Int, range: Range): Boolean {
    return value >= range.first && value <= range.second
}

fun zeroInRange(ranges: MutableList<Range>, name: String, ifTrue: Int, ifFalse: Int): Int {
    return if (inRange(0, ranges[nameToNumber(name)])) ifTrue else ifFalse
}

fun implementRange(initial: Range, instructions: List<Instruction>): Range {
    var ranges = mutableListOf<Range>(initial, Pair(0, 0), Pair(0, 0))
    val maxNumberOfSteps = 100
    var curNumberOfSteps = 0
    var index = 0
    while (curNumberOfSteps < maxNumberOfSteps && index < instructions.count()) {
        val instruction = instructions[index]
        when (instruction.first) {
            0 -> return ranges[1]
            1 -> {
                ranges = incrementRange(instruction.second[0], ranges)
                index += 1
            }
            2 -> {
                ranges = decrementRange(instruction.second[0], ranges)
                index += 1
            }
            3 -> {
                index = zeroInRange(ranges, instruction.second[0], instruction.second[1].toInt(), instruction.second[3].toInt())
            }
        }
        curNumberOfSteps += 1
    }
    return ranges[1]
}

fun main() {
    println("Choose mode:\n1. For one value\n2. For Interval")
    val mode = readLine()!!.toInt()
    if (mode == 1) {
        println("Input initial value:")
        val initial = readLine()!!.toInt()
        println(implement(initial, readInstructions()))
    }
    else {
        println("Input initial Range(two numbers on separate lines):")
        val from = readLine()!!.toInt()
        val to = readLine()!!.toInt()
        println(implementRange(Pair(from, to), readInstructions()))
    }
}