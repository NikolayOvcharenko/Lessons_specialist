package test

fun String?.isEmptyOrNull(): Boolean = this?.isEmpty() ?: true

open class Base
class Child: Base()
data class RationalNumber(var numerator: Int, val denominator: Int)

fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)
infix fun Int.sm(othet: Int) = this + othet
fun Base.hello(): String = "Hi Base"
fun Child.hello(): String = "Hello Child"



fun main() {

    val child: Base = Child()
    println(child.hello())

    println(12.sm(22))
    println(12 sm 22)

    println(34.r())
    println((25 to 45).r())
}