@file: JvmName("main")

import java.util.*

// Does an access to memory and returns number of replacements needed (0 or 1).
fun processFIFO(currentMemory: MutableList<Int>, queueOfBlocks: LinkedList<Int>, query: Int): Int {
    if (query in currentMemory) {
        return 0
    }
    val index = queueOfBlocks.remove()
    queueOfBlocks.add(index)
    currentMemory[index] = query
    return 1
}

// Does an access to memory and returns number of replacements needed (0 or 1).
fun processLRU(currentMemory: MutableList<Int>, queueOfBlocks: MutableList<Int>, query: Int): Int {
    var answer = 0
    val index: Int
    if (query in currentMemory) {
        index = currentMemory.indexOf(query)
    } else {
        index = queueOfBlocks.first()
        currentMemory[index] = query
        answer = 1
    }
    queueOfBlocks.remove(index)
    queueOfBlocks.add(index)
    return answer
}

fun run() {
    val rnd = Random()
    val memSize = 100
    val ramSize = 50
    // $currentMemory is a collection of blocks that are in RAM at the moment.
    val currentMemoryForFIFO = (1..ramSize).toMutableList()
    val currentMemoryForLRU = (1..ramSize).toMutableList()
    // $queueOfBlocksForFIFO is a queue of RAM blocks ordered by the chance of replacing in FIFO.
    val queueOfBlocksForFIFO = LinkedList<Int>((0 until ramSize).toList())
    // $queueOfBlocksForLRU is a priority queue ordered by the chance of replacing in LRU.
    val queueOfBlocksForLRU = MutableList(ramSize) { i -> i }
    val seq = generateSequence(rnd.nextInt() % memSize + 1) { rnd.nextInt() % memSize + 1 }
    val iter = seq.iterator()
    var answerFIFO = 0
    var answerLRU = 0
    repeat(10000) {
        val query = iter.next()
        answerFIFO += processFIFO(currentMemoryForFIFO, queueOfBlocksForFIFO, query)
        answerLRU += processLRU(currentMemoryForLRU, queueOfBlocksForLRU, query)
    }
    println("FIFO: $answerFIFO")
    println("LRU: $answerLRU")
    println()
}

fun main() {
    repeat(10) {
        run()
    }
}