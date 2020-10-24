import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class mainTest {

    @Test
    fun test1() {
        assertEquals(-24824560, Var(-24824560).calc())
    }

    @Test
    fun test2() {
        assertEquals(-711545113, Var(-711545113).calc())
    }

    @Test
    fun test3() {
        assertEquals(-2008595430, Var(-2008595430).calc())
    }

    @Test
    fun test4() {
        assertEquals(413878301, Var(413878301).calc())
    }

    @Test
    fun test5() {
        assertEquals(643090450, Var(643090450).calc())
    }

    @Test
    fun test6() {
        assertEquals(815167056, Var(815167056).calc())
    }

    @Test
    fun test7() {
        assertEquals(-32539489, Var(-32539489).calc())
    }

    @Test
    fun test8() {
        assertEquals(-559234833, Var(-559234833).calc())
    }

    @Test
    fun test9() {
        assertEquals(-108838676, Sum(Var(28867047), Var(-137705723)).calc())
    }

    @Test
    fun test10() {
        assertEquals(605917576, Sum(Var(-79086392), Var(685003968)).calc())
    }

    @Test
    fun test11() {
        assertEquals(779698151, Sum(Var(823832943), Var(-44134792)).calc())
    }

    @Test
    fun test12() {
        assertEquals(126621482, Sum(Var(-581937098), Var(708558580)).calc())
    }

    @Test
    fun test13() {
        assertEquals(-578918130, Sum(Var(-564960848), Var(-13957282)).calc())
    }

    @Test
    fun test14() {
        assertEquals(234987134, Sum(Var(220557717), Var(14429417)).calc())
    }

    @Test
    fun test15() {
        assertEquals(1071829646, Sum(Var(964669627), Var(107160019)).calc())
    }

    @Test
    fun test16() {
        assertEquals(653983164, Sum(Var(715982973), Var(-61999809)).calc())
    }

    @Test
    fun test17() {
        assertEquals(321768, Mul(Var(-2952), Var(-109)).calc())
    }

    @Test
    fun test18() {
        assertEquals(-8783380, Mul(Var(2572), Var(-3415)).calc())
    }

    @Test
    fun test19() {
        assertEquals(-18813232, Mul(Var(4456), Var(-4222)).calc())
    }

    @Test
    fun test20() {
        assertEquals(-21063246, Mul(Var(4934), Var(-4269)).calc())
    }

    @Test
    fun test21() {
        assertEquals(-8619374, Mul(Var(-2686), Var(3209)).calc())
    }

    @Test
    fun test22() {
        assertEquals(24019497, Mul(Var(2781), Var(8637)).calc())
    }

    @Test
    fun test23() {
        assertEquals(42164672, Mul(Var(-6523), Var(-6464)).calc())
    }

    @Test
    fun test24() {
        assertEquals(-18670851, Mul(Var(7129), Var(-2619)).calc())
    }

    @Test
    fun test25() {
        assertEquals("(2 + 3) * 4", Mul(Sum(Var(2), Var(3)), Var(4)).toString())
    }

    @Test
    fun test26() {
        assertEquals("((2 + 2) + (2 * 4 + 3) * 4) * 10", Mul(Sum(Sum(Var(2), Var(2)), Mul(Sum(Mul(Var(2), Var(4)), Var(3)), Var(4))), Var(10)).toString())
    }

    @Test
    fun test27() {
        assertEquals("5", Var(5).toString())
    }

    @Test
    fun test28() {
        assertEquals("(2 + 3)", Sum(Var(2), Var(3)).toString())
    }

    @Test
    fun test29() {
        assertEquals("2 * 2", Mul(Var(2), Var(2)).toString())
    }

    @Test
    fun test30() {
        assertEquals("3 * (4 + 5)", Mul(Var(3), Sum(Var(4), Var(5))).toString())
    }

    @Test
    fun test31() {
        assertEquals("(3 * 3 + 4 * 4)", Sum(Mul(Var(3), Var(3)), Mul(Var(4), Var(4))).toString())
    }

    @Test
    fun test32() {
        assertEquals("((((1 + 2) + 3) + 4) + 5)", Sum(Sum(Sum(Sum(Var(1), Var(2)), Var(3)), Var(4)), Var(5)).toString())
    }
}