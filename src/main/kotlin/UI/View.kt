package UI

interface View {
    fun click()
    fun whoAmI() = println("I'm a view!!")
}

class Button: View, Shape {
    override fun click() = println("Button click")
    override fun whoAmI() {
        super<View>.whoAmI()
        super<Shape>.whoAmI()
    }
}

class TwextView: View {
    override fun click() = println("TextView click")
    override fun whoAmI() = println("I'm a textview")
}

interface Shape {
    fun whoAmI() = println("I'm a shape")
}

fun main() {
//    val button = Button()
//    button.click()
//    button.whoAmI()

    val v1: View = Button()
    val v2: View = TwextView()
    v1.whoAmI()
    v2.whoAmI()
}