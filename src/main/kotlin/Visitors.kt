package vis

val calculateVisitor: (Action) -> Int = createVisitor(
    value = { it },
    add = { l, r -> l + r },
    multiply = { l, r -> l * r },
    doFinally = { it }
)

val expandVisitor: (Action) -> String = createVisitor(
    value = { listOf(it.toString()) },
    add = { l, r -> l + r },
    multiply = { l, r -> l.flatMap { left -> r.map { right -> "$left * $right" } } },
    doFinally = { it.joinToString(" + ") }
)

val printVisitor: (Action) -> String = createVisitor(
    value = { Priority(it.toString(), 0) },
    add = { l, r -> Priority("${l.str} + ${r.str}", 1) },
    multiply = { l, r ->
        val left = if (l.priority == 0) (l.str) else "(${l.str})"
        val right = if (r.priority == 0) (r.str) else "(${l.str})"
        Priority("$left * $right", 0)
    },
    doFinally = { it.str }
)
