package vis

fun <T, R> createVisitor(value: (Int) -> T, add: (T, T) -> T, multiply: (T, T) -> T, doFinally: (T) -> R): (Action) -> R {
    fun compute(action: Action): T {
        if (action is Sum)
            return add(compute(action.l), compute(action.r))
        if (action is Value)
            return value(action.value)
        if (action is Production)
            return multiply(compute(action.l), compute(action.r))
        throw RuntimeException("Unsupported expression")
    }
    return { doFinally(compute(it)) }
}

data class Priority(val str: String, val priority: Int)
