import java.io.File
import java.lang.Exception
import kotlin.math.max
import kotlin.math.min

class InvalidInputException(message: String) : Exception(message)
class InvalidProgramException(message: String) : Exception(message)
sealed class Instruction
typealias Var = Int

data class Increment(val index: Var) : Instruction()
data class Decrement(val index: Var) : Instruction()
data class Zero(val index: Var, val line1: Int, val line2: Int) : Instruction()
object Stop : Instruction()

fun charToVar(char: Char): Var {
    return char - 'x'
}

fun parseProgram(lines: List<String>): List<Instruction> {
    return lines.map {
        when {
            Regex("inc [xyz]").matches(it) -> Increment(charToVar(it.last()))
            Regex("dec [xyz]").matches(it) -> Decrement(charToVar(it.last()))
            it == "stop" -> Stop
            else -> {
                val (index, line1, line2) = Regex("zero ([xyz]) ([1-9][0-9]*) else ([1-9][0-9]*)").matchEntire(it)?.destructured
                    ?: throw InvalidInputException("Invalid instruction")
                Zero(charToVar(index[0]), line1.toInt() - 1, line2.toInt() - 1)
            }
        }
    }
}

fun execute(program: List<Instruction>, input: Int, maxSteps: Int = 10000): Int {
    if (input < 0)
        throw InvalidProgramException("Input is less than zero")
    var line = 0
    var steps = 0
    val variables = mutableListOf(input, 0, 0)
    while (line < program.size) {
        steps++
        if (steps > maxSteps)
            throw InvalidProgramException("Execution takes more than $maxSteps steps")
        when (val instruction = program[line]) {
            is Increment -> {
                variables[instruction.index]++
                line++
            }
            is Decrement -> {
                if (variables[instruction.index] == 0)
                    throw InvalidProgramException("Variable becomes less than zero")
                variables[instruction.index]--
                line++
            }
            is Zero -> {
                line = if (variables[instruction.index] == 0)
                    instruction.line1
                else
                    instruction.line2
            }
            is Stop -> {
                break
            }
        }
    }
    return variables[1]
}

data class Range(val first: Int, val last: Int) {
    fun increment() = Range(first + 1, last + 1)
    fun decrement() = Range(max(first - 1, 0), max(last, 0) - 1)
    fun isEmpty() = last < first
    override fun toString(): String = if (isEmpty()) "()" else "$first..$last"
}

fun union(left: Range, right: Range): Range {
    if (left.isEmpty())
        return right
    if (right.isEmpty())
        return left
    return Range(min(left.first, right.first), max(left.last, right.last))
}

data class VarRanges(val ranges: MutableList<Range>) {
    constructor(rangeX: Range, rangeY: Range, rangeZ: Range): this(mutableListOf(rangeX, rangeY, rangeZ))
    fun update(other: VarRanges): Boolean {
        if (other.ranges.any { it.isEmpty() })
            return false
        assert(ranges.all {it.isEmpty()} || ranges.none {it.isEmpty()})
        var result = false
        for (index in 0..2) {
            val newRange = union(ranges[index], other.ranges[index])
            if (ranges[index] != newRange)
                result = true
            ranges[index] = newRange
        }
        return result
    }

    fun modify(index: Var, range: Range): VarRanges =
        VarRanges((ranges.take(index) + range + ranges.drop(index + 1)).toMutableList())

    fun increment(index: Var): VarRanges = modify(index, ranges[index].increment())
    fun decrement(index: Var): VarRanges = modify(index, ranges[index].decrement())
    fun setZero(index: Var): VarRanges = modify(index, Range(ranges[index].first, 0))
    fun setNotZero(index: Var): VarRanges = modify(index, Range(1, ranges[index].last))
    override fun toString(): String {
        return listOf("x", "y", "z").zip(ranges).joinToString(" ") { (varName, interval) -> "$varName $interval" }
    }
}

fun executeIntervals(program: List<Instruction>, input: Range, maxSteps: Int = 10000): List<VarRanges> {
    val intervals = MutableList(program.size + 1) { VarRanges(MutableList(3) { Range(0, -1) }) }
    intervals[0] = VarRanges(mutableListOf(input, Range(0, 0), Range(0, 0)))
    for (step in 1..maxSteps) {
        var changed = false
        for ((line, instruction) in program.withIndex()) {
            when (instruction) {
                is Increment -> {
                    if (intervals[line + 1].update(intervals[line].increment(instruction.index)))
                        changed = true
                }
                is Decrement -> {
                    if (intervals[line + 1].update(intervals[line].decrement(instruction.index)))
                        changed = true
                }
                is Zero -> {
                    if (intervals[line].ranges[instruction.index].first == 0) {
                        if (intervals[instruction.line1].update(intervals[line].setZero(instruction.index)))
                            changed = true
                    }
                    if (intervals[instruction.line2].update(intervals[line].setNotZero(instruction.index)))
                        changed = true
                }
                is Stop -> {
                }
            }
        }
        if (!changed)
            break
    }
    return intervals
}

fun getResultRange(program: List<Instruction>, intervals: List<VarRanges>): Range {
    return intervals.withIndex().filter { (line, _) -> line >= program.size || program[line] is Stop }
        .fold(Range(0, -1), { range, (_, current) -> union(range, current.ranges[1]) })
}

private fun processIntervals(inputRange: String, program: List<Instruction>) {
    val (l, r) = inputRange.split('-').map { it.toIntOrNull() }
    if (l == null || r == null || l > r || l < 0)
        throw InvalidInputException("Input limits are not valid")
    val intervals = executeIntervals(program, Range(l, r))
    println(intervals.withIndex().joinToString("\n") { (line, varRanges) -> "${line+1} $varRanges" })
    println("result ${getResultRange(program, intervals)}")
}

fun main(args: Array<String>) {
    try {
        if (args.size != 2)
            throw InvalidInputException("Arguments should be input file name and input or range of inputs")
        val program = parseProgram(File(args[0]).readLines())
        if ('-' in args[1]) {
            processIntervals(args[1], program)
        } else {
            val input = args[1].toIntOrNull()
                ?: throw InvalidInputException("Input is not integer")
            println(execute(program, input))
        }
    } catch (e: InvalidInputException) {
        println(e.message)
    } catch (e: InvalidProgramException) {
        println(e.message)
    } catch (e: Exception) {
        println("Unknown error")
    }
}