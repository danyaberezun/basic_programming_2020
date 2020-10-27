import org.junit.jupiter.api.Assertions.*

import src.*

internal class PlotkinKtTest {

    @org.junit.jupiter.api.Test
    fun nextState() {
        val instructions = listOf(
                Instruction(InstructionType.Stop),
                Instruction(InstructionType.Inc, 1),
                Instruction(InstructionType.Dec, 2),
                Instruction(InstructionType.Zero, 0, 34, 87))
        assertEquals(null, nextState(instructions, State(0, listOf(12, 54, 101))))
        assertEquals(State(2, listOf(12, 55, 101)), nextState(instructions, State(1, listOf(12, 54, 101))))
        assertEquals(State(3, listOf(12, 54, 100)), nextState(instructions, State(2, listOf(12, 54, 101))))
        assertEquals(State(87, listOf(12, 54, 101)), nextState(instructions, State(3, listOf(12, 54, 101))))
        assertEquals(State(34, listOf(0, 54, 101)), nextState(instructions, State(3, listOf(0, 54, 101))))
    }
}