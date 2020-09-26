package src

fun getNthFibonacci(firstElement: Int, secondElement: Int, n: Int): Int{
    if(n == 1) return firstElement
    if(n >= 2) return getNthFibonacci(secondElement, firstElement + secondElement, n - 1)
    return getNthFibonacci(secondElement - firstElement, firstElement, n + 1)
}

fun checkInput(line: String?) : Boolean{
    if(line == null) return false
    if(line.split(' ').size != 3) return false
    if(line.split(' ').map{it.toIntOrNull()}.filter({it != null}).size != 3) return false
    return true
}

fun main(){
    val line = readLine()
    if(checkInput(line)) {
        val (firstElement, secondElemrnt, n) = line!!.split(' ').map { it.toInt() }
        println(getNthFibonacci(firstElement, secondElemrnt, n))
    }else{
        println("Something went wrong")
    }
}