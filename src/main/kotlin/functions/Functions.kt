package functions

import java.lang.StringBuilder

class LazyClass(initialyzer: () -> Int) {
    val initial: Int by lazy { initialyzer() }
}

fun Int.isEven(): Boolean = this % 2 != 0
fun Int.isOsd(): Boolean = this % 2 == 0


class Counter {
    var numberOgGets = 0
    var number: Int = 0
        get() {
            numberOgGets++
            return field
        }
}

fun Collection<String>.formatString(
    prefix: String = "[",
    suffix: String = "]",
    delim: String = ",",
    processor: (String) -> String = { it }
): String {
    val result = StringBuilder()
    result.append(prefix)
    for ((index, element) in this.withIndex()) {
        if (index != 0)
            result.append(delim)
        result.append(processor(element))
    }
    result.append(suffix)
    return result.toString()
}


fun main() {

    println(
        listOf("abc", "def", "jhk").formatString("{", "}", "-") {"" + it.length} // [abc,def,jhk]
    )

/*
    println(12.isEven())
    println(15.isOsd())

    val init: () -> Int = {
        println("INIT")
        3
    }

    val lazyClass = LazyClass(init)
    lazyClass.initial
    lazyClass.initial
*/
}