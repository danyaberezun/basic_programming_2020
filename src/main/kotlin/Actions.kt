package vis

sealed class Action {
    operator fun plus(other: Action): Action {
        return Sum(this, other)
    }
    operator fun times(other: Action): Action {
        return Production(this, other)
    }
}

class Value(val value: Int): Action()

class Sum(val l: Action, val r: Action): Action()

class Production(val l: Action, val r: Action): Action()
