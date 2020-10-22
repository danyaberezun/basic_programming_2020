@file: JvmName("main")
package foo

import java.lang.RuntimeException

fun qsort(input_s: List<Int>): List<Int> {
    var input = input_s.toMutableList();

    fun partition(start_i: Int, end_i: Int): Int {
        var pivot = input[end_i];
        var left_p = start_i;
        var right_p = end_i -1;
        while (left_p <= right_p) {
            while ( (left_p <= end_i) && (input[left_p] < pivot) ) {
                left_p += 1;
            }
            while ( (right_p >= start_i) && (input[right_p] >= pivot)) {
                right_p -= 1;
            }

            if (left_p < right_p) {
                val l = input[left_p];
                val r = input[right_p];
                input[left_p] = r;
                input[right_p] = l;
            } else {
                input[end_i] = input[left_p]
                input[left_p] = pivot
            }
        }
        return left_p
    }
    fun sublist(start_i: Int, end_i: Int) {
        if (start_i >= end_i) return;
        val pivot_i = partition(start_i, end_i)
        sublist(start_i, pivot_i-1)
        sublist(pivot_i+1, end_i)
    }

    sublist(0, input.size-1)
    return input;
}



fun reverse(input: List<Int>): List<Int> {
    var res = mutableListOf<Int>()
    return input.foldRight(res,{ i,r -> r.add(i); r });
}

fun filter(input: List<Int>, f: (Int)-> Boolean): List<Int> {
    var res = mutableListOf<Int>()
    return input.fold(res, fun (r: MutableList<Int>, i): MutableList<Int> {
        if (f(i)) { r.add(i) }
        return r;
    });
}

fun filter_r(input: List<Int>, f: (Int)-> Boolean): List<Int> {
    var res = mutableListOf<Int>()
    return input.foldRight(res, fun (i, r: MutableList<Int>): MutableList<Int> {
        if (f(i)) { r.add(0, i) }
        return r;
    });
}

fun countLines(input: List<String>): List<Int> {
    return input.map { it.length }
}

fun sumq(input: Int): Int {
    var acc = 0;
    for (i in 0..input) {
        acc += i*i;
    }
    return acc;
}

fun mapAccumL( x: Int, y: List<Int>, f: (Int, Int) -> Pair<Int, Int>): Pair<Int, List<Int>> {
    var x_result = x;
    var y_result = mutableListOf<Int>()

    for (yv in y) {
        val (xn, yn) = f(x_result, yv);
        x_result = xn;
        y_result.add(yn);
    }
    return Pair(x_result, y_result);
}

fun main() {

}