@file:JvmName("Main")

package com.fibon.mikrise2

import java.io.File
import java.util.*

fun main() {
    val file = File("fibonNumber.txt")
    val scan = Scanner(file)
    print(fibon(scan.nextInt()))

}

fun fibon(n: Int): String {
    var first_element = 0
    var second_element = 1
    var temporary:Int
    var line = ""
    line = line.plus("$first_element")
    for (i in 2..n) {
        line = line.plus(" $second_element")
        temporary = first_element
        first_element = second_element
        second_element = first_element + temporary
    }
    return line
}