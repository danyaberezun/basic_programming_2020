package com.fibon.mikrise2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun testFibon() {
        assertEquals(fibon(11),"0 1 1 2 3 5 8 13 21 34 55")
        assertEquals(fibon(10),"0 1 1 2 3 5 8 13 21 34")
        assertEquals(fibon(9),"0 1 1 2 3 5 8 13 21")
        assertEquals(fibon(8),"0 1 1 2 3 5 8 13")
        assertEquals(fibon(7),"0 1 1 2 3 5 8")
        assertEquals(fibon(6),"0 1 1 2 3 5")
        assertEquals(fibon(5),"0 1 1 2 3")
        assertEquals(fibon(4),"0 1 1 2")
        assertEquals(fibon(3),"0 1 1")
        assertEquals(fibon(2),"0 1")
        assertEquals(fibon(1),"0")
    }

}