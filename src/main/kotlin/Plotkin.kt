package src

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

data class State(val pc: Int, val list: List<Int>){}

enum class InstructionType{
    Inc, Dec, Zero, Stop
}

typealias VarId = Int
typealias PC = Int

data class Instruction(val instructionType: InstructionType, val varId: VarId = 1, val pc: PC = 1, val pc1: PC = 1)

fun getInstructions(): List<Instruction>{
    val instructions = mutableListOf<Instruction>()
    try {
        File("input.txt").forEachLine {
            val splittedLine = it.split(" ")
            val instruction = when(splittedLine.firstOrNull()){
                "Inc" -> Instruction(InstructionType.Inc, splittedLine[1].toInt())
                "Dec" -> Instruction(InstructionType.Dec, splittedLine[1].toInt())
                "Stop" -> Instruction(InstructionType.Stop)
                "Zero" -> Instruction(InstructionType.Zero, splittedLine[1].toInt(), splittedLine[2].toInt(), splittedLine[3].toInt())
                else -> throw Exception("Wrong format of instruction!")
            }
            instructions.add(instruction)
        }
    } catch(e : FileNotFoundException){
        throw FileNotFoundException()
    } catch(e : IndexOutOfBoundsException){
        throw Exception("Wrong format of instruction!")
    }catch(e : NullPointerException){
        throw Exception("Wrong format of instruction!")
    }
    return instructions
}

fun nextState(instructions: List<Instruction>, state: State): State? {
    val instruction = instructions[state.pc]
    return when(instruction.instructionType) {
        InstructionType.Inc ->
            State(state.pc + 1, state.list.mapIndexed { id, it -> if (id == instruction.varId) it + 1 else it })
        InstructionType.Dec ->
            State(state.pc + 1, state.list.mapIndexed { id, it -> if (id == instruction.varId) it - 1 else it })
        InstructionType.Zero ->
            if(state.list[instruction.varId] == 0)
                State(instruction.pc, state.list)
            else
                State(instruction.pc1, state.list)
        InstructionType.Stop -> null
    }
}

fun runInstructions(initialState: State, instructions: List<Instruction>): State{
    var currentState = initialState
    while(nextState(instructions, currentState) != null){
        currentState = nextState(instructions, currentState)!!
        println("${currentState.pc} ${currentState.list[0]} ${currentState.list[1]} ${currentState.list[2]}")
    }
    return currentState
}

fun main(vararg args: String){

    val instructions = getInstructions()

    if(args.isNotEmpty() || args[0] == "-ia"){
        if(args[1].toIntOrNull() == null || args[2].toIntOrNull() == null){
            throw IllegalArgumentException("Wrong interval format")
        }
        for(i in args[1].toInt()..args[2].toInt()){
            val initialState = State(0, listOf(i, 0, 0))

            val finalState = runInstructions(initialState, instructions)

            println(finalState.list[1])
        }

    }else {
        if (args.size != 0 || args[0].toIntOrNull() == null) {

            throw IllegalArgumentException("Wrong start value format")
        }

        val initialState = State(0, listOf(args[0].toInt(), 0, 0))

        val finalState = runInstructions(initialState, instructions)

        println(finalState.list[1])
    }

}