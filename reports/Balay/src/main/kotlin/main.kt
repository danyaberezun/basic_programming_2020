package hw3

fun quicksort(arr: List<Int>): List<Int> {
    if(arr.size <= 1)
        return arr
    val piv = arr.first()
    val arr1 = arr.filter {it < piv}
    val arr3 = arr.filter {it > piv}
    val arr2 = arr.filter {it == piv}
    return quicksort(arr1) + arr2 +  quicksort(arr3)
}

fun main() {

}