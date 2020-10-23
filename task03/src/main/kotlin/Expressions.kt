package main

//10
fun createExpression1(): Node {
    return Variable(10)
}

//(3 + 32) * 23 == 805
fun createExpression2(): Node {
    val variable1 = Variable(3) //3
    val variable2 = Variable(32) //32
    val sum1 = Sum(variable1, variable2) //3 + 32
    val variable3 = Variable(23) //23
    return Multiply(sum1, variable3) //(3 + 32) * 23
}

//20 * 15 * (6 + 9) + 12 == 4512
fun createExpression3(): Node {
    val variable1 = Variable(20) //20
    val variable2 = Variable(15) /// 15
    val multiply1 = Multiply(variable1, variable2) //20 * 15
    val variable3 = Variable(6) //6
    val variable4 = Variable(9) //9
    val sum1 = Sum(variable3, variable4) //6 + 9
    val multiply2 = Multiply(multiply1, sum1) //20 * 15 * (6 + 9)
    val variable5 = Variable(12) //12
    return Sum(multiply2, variable5) //20 * 15 * (6 + 9) + 12
}


//((3 + 32) * 23 + 65 * 21) * 34 == 73780
fun createExpression4(): Node {
    val expression1 = createExpression2() //(3 + 32) * 23
    val variable1 = Variable(65) //65
    val variable2 = Variable(21) //21
    val multiply1 = Multiply(variable1, variable2) //65 * 21
    val sum1 = Sum(expression1, multiply1) //(3 + 32) * 23 + 65 * 21
    val variable3 = Variable(34)
    return Multiply(sum1, variable3) //((3 + 32) * 23 + 65 * 21) * 34
}

//(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34 * 3 + 3 == 998686083
fun createExpression5(): Node {
    val expression1 = createExpression3() //20 * 15 * (6 + 9) + 12
    val expression2 = createExpression4() //((3 + 32) * 23 + 65 * 21) * 34
    val variable1 = Variable(3) //3
    val multiply1 = Multiply(expression1, expression2) //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34)
    val multiply2 = Multiply(multiply1, variable1) //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34 * 3
    return Sum(multiply2, variable1) //(20 * 15 * (6 + 9) + 12) * ((3 + 32) * 23 + 65 * 21) * 34 * 3 + 3
}