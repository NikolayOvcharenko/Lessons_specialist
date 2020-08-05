package operators

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

class Rect(val ul: Point, val lr: Point)

operator fun Rect.contains(p: Point) = p.x in ul.x..lr.x && p.y in ul.y..lr.y

class Headehog() {
    fun whoAmi() = println("I'm Headgehog")
    // operator fun plus(other: Snake) = BarbWire()
}

class Snake() {
    fun whoAmi() = println("I'm Snake")
    operator fun plus(other: Headehog) = BarbWire()
}

class BarbWire() {
    fun whoAmi() = println("I'm Barbwire")
}

operator fun Headehog.plus(other: Snake) = BarbWire()

val lazyValue: String by lazy {
    println("Init")
    "Hello"
}


class LateInit {
    val name: String = "MmM"

    lateinit var late: String
    fun init() {
        println(this::late.isInitialized)
        late = "Init"
        println(this::late.isInitialized)
    }
}

fun main() {

    var lateInit = LateInit()
    lateInit.init()
    println(lateInit.late)

    println(lazyValue)
    println(lazyValue)

    val point1 = Point(3, 3)
    val point2 = Point(5, 5)

    println(point1 + point2)


    val rect = Rect(Point(4, 4), Point(20, 10))
    println(point1 in rect)
    println(point2 in rect)


    val head = Headehog()
    val snake = Snake()
    println((snake + head).whoAmi())

}