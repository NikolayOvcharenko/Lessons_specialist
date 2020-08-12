package calculator

import javax.print.attribute.standard.MediaSize

class Calculator (private var result: Int = 0){

    fun get() = result
    // add
    // mul
    // add
    // div
    fun add(other: Int): Unit { result += other }
    fun mul(other: Int): Unit { result *= other }
    fun sub(other: Int): Unit { result -= other }
    fun div(other: Int): Unit {
        assert(other != 0) {"Division by Zero"}
        result /= other
    }
}