package color

enum class Color
    (val r: Int, val g: Int, val b: Int) {
    RED(r = 255, g = 0, b = 0), GREEN(r = 0, g = 255, b = 0), BLUE(r = 0, g = 0, b = 255);

    fun rgb() = r * 255 * 255 + g * 255 + b * 255
}

fun main() {
    println(Color.RED)
}