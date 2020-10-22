import java.lang.IllegalArgumentException

open class Expression {
    class Literal(val value: Int) : Expression()
    class Sum(val left: Expression, val right: Expression) : Expression()
    class Product(val left: Expression, val right: Expression) : Expression()

    operator fun plus(other: Expression): Expression {
        return Sum(this, other)
    }
    operator fun times(other: Expression): Expression {
        return Product(this, other)
    }
}

fun <T, R> createVisitor(
    literal: (Int) -> T,
    add: (T, T) -> T,
    multiply: (T, T) -> T,
    finalize: (T) -> R
): (Expression) -> R {
    fun apply(expression: Expression): T {
        return when (expression) {
            is Expression.Literal -> literal(expression.value)
            is Expression.Sum -> add(apply(expression.left), apply(expression.right))
            is Expression.Product -> multiply(apply(expression.left), apply(expression.right))
            else -> throw(IllegalArgumentException("Unknown expression"))
        }
    }
    return { finalize(apply(it)) }
}

data class ExpressionPriority(val string: String, val priority: Int)

val printVisitor = createVisitor<ExpressionPriority, String>({ ExpressionPriority(it.toString(), 0) },
    { l, r -> ExpressionPriority("${l.string} + ${r.string}", 1) },
    { l, r ->
        val left = if (l.priority == 0) (l.string) else "(${l.string})"
        val right = if (r.priority == 0) (r.string) else "(${l.string})"
        ExpressionPriority("$left * $right", 0)
    },
    { it.string })

val calculateVisitor = createVisitor<Int, Int>({ it }, { l, r -> l + r }, { l, r -> l * r }, { it })
val expandVisitor = createVisitor<List<String>, String>({ listOf(it.toString()) },
    { l, r -> l + r },
    { l, r -> l.flatMap { left -> r.map { right -> "$left*$right" } } },
    { it.joinToString(" + ") })