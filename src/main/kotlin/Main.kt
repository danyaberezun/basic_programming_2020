package src

fun quickSort(list: List<Int>): List<Int>{
    return list
}

fun reverse(list: List<Int>): List<Int>{
    return list.foldRight(listOf<Int>()){ item, total -> total + listOf(item)}
}

fun filter(list: List<Int>, f: (Int) -> Boolean): List<Int>{
    return list.fold(listOf<Int>()){ total, item -> (if(f(item)) listOf(item) else listOf<Int>()) + total}
}

fun filterRight(list: List<Int>, f: (Int) -> Boolean): List<Int>{
    return list.foldRight(listOf<Int>()){ item, total -> (if(f(item)) listOf(item) else listOf<Int>()) + total}
}

fun lengths(list: List<String>): List<Int>{
    return list.fold(listOf<Int>()){total, item -> total + listOf(item.length)}
}

fun sumsq(n: Int): Int{
    return generateSequence(1) { it + 1 }.map{x -> x*x}.take(n).sum()
}

fun List<Int>.mapAccumL(function: (Int, Int) -> Pair<Int, Int>, initial: Int): Pair<Int, List<Int>>{
    return this.drop(1).fold(
            Pair(function(initial, this[0]).first,
            listOf(function(initial, this[0]).second))
    ){total, item -> Pair(function(total.first, item).first, total.second + function(total.first, item).second)}
}


fun main(){

}