@file:JvmName("Main")

import java.io.File
import java.text.BreakIterator
import java.util.*
import kotlin.collections.ArrayList

var x = 0
var y = 0
var z = 0
var page = 1
var check = false
fun main() {
    val strings = ArrayList<ArrayList<String>>()
    File("file.txt").forEachLine {
        strings.add(getWords(it))
    }
    val scan = Scanner(File("input.txt"))

    while (scan.hasNext()) {
        println()
        check = false
        y = 0
        z = 0
        page = 1
        x = scan.nextInt()
        println("Initial state <1,$x,0,0>")
        while (!check) {
            interpret(strings[page - 1])
        }
        println("Final state <$page,0,$y,0>")
    }
}


fun getWords(text: String): ArrayList<String> {
    val words: ArrayList<String> = ArrayList()
    val breakIterator = BreakIterator.getWordInstance()
    breakIterator.setText(text)
    var lastIndex = breakIterator.first()
    while (BreakIterator.DONE != lastIndex) {
        val firstIndex = lastIndex
        lastIndex = breakIterator.next()
        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text[firstIndex])) {
            words.add(text.substring(firstIndex, lastIndex))
        }
    }
    return words
}

fun interpret(strings: ArrayList<String>?) {
    when (strings?.get(0)) {
        "inc" -> {
            when (strings[1]) {
                "x" -> x++
                "y" -> y++
                "z" -> z++
            }
            page++
        }
        "dec"
        -> {
            when (strings[1]) {
                "x" -> x--
                "y" -> y--
                "z" -> z--
            }
            page++
        }
        "zero"
        -> {
            when (strings[1]) {
                "x" -> {
                    page = if (x == 0) {
                        strings[2].toInt()
                    } else {
                        strings[4].toInt()
                    }
                }
                "y" -> {
                    page = if (y == 0) {
                        strings[2].toInt()
                    } else {
                        strings[4].toInt()
                    }
                }
                "z" -> {
                    page = if (z == 0) {
                        strings[2].toInt()
                    } else {
                        strings[4].toInt()
                    }
                }
            }
        }
        "stop"
        -> {
            check = true
            x = 0
        }
    }
}


