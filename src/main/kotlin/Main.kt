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


fun main(){

}