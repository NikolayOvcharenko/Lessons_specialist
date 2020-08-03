package over

import javax.print.attribute.standard.MediaSize

interface Clicable {
    fun click()
}

open class RichButton: Clicable {
    override fun click() {
        TODO("Not yet implemented")
    }
    open fun disable() {}
    fun focus() {}
}

abstract class Animated {   //abstract - открыт для наследования
    abstract fun animate()  //abstract - нужно override в подклассах
    fun startAnimate() {}   // нет open но есть реализация - нельзя override в подклассах
    open fun stopAnim() {}  // есть open - можно override в подклассах
}

class AnimatedButton: RichButton() {
    override fun click() {}
    override fun disable() {}
}

class Animator: Animated() {
    override fun animate() {}
    override fun stopAnim() {}
}


class Outer {       // Внешний
    class Nested {  // Вложенный

    }
    inner class Internal{ // Внутренний
        fun getOuter(): Outer = this@Outer
    }
}

open class Base(){
    open var name: String = ""
    init {
        println("Base init block")
    }
}

class User(): Base() {
    // override lateinit var name: String
    init {
        println("init block")
        // this.name = name
    }
    constructor(name: String = "Max") : this() {
        println("constructor")
        this.name = name
    }
}

class Secret {
    private constructor()
}

data class Client(val name: String, val index: Int) {
 /*   override fun toString(): String {
        return "name: $name, index: $index"
    }
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name== other.name && index == other.index
    }
    // copy, component1... componentN
    override fun hashCode(): Int = name.hashCode()*37 + index */
}

fun main() {
    val masha = Client("Misha", 121222)
    val misha = Client("Misha", 121222)
    println(misha)
    println(misha == masha)
    val set = hashSetOf(misha)
    println(set.contains(masha))

    val vasya = masha.copy(name = "Vasya")
    val name = User("Nix")

    val outer = Outer()
    val nested = Outer.Nested()
    val internal = outer.Internal()
}