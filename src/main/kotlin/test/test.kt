package test

fun String?.isEmptyOrNull(): Boolean = this?.isEmpty() ?: true

open class Base
class Child : Base()
data class RationalNumber(var numerator: Int, val denominator: Int)

operator fun RationalNumber.plus(r: RationalNumber): RationalNumber = RationalNumber(
    (numerator * r.denominator + denominator * r.numerator), (r.denominator * denominator)
)

operator fun RationalNumber.times(r: RationalNumber): RationalNumber = RationalNumber(
    (numerator * r.numerator), (r.denominator * denominator)
)


fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)
infix fun Int.sm(othet: Int) = this + othet
fun Base.hello(): String = "Hi Base"
fun Child.hello(): String = "Hello Child"


fun main() {


    val r1 = RationalNumber(1, 3)
    val r2 = RationalNumber(3, 4)
    println(r1 + r2)
    println(r1 * r2)

    val child: Base = Child()
    println(child.hello())

    println(12.sm(22))
    println(12 sm 22)

    println(34.r())
    println((25 to 45).r())
}