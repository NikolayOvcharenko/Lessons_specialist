package `object`

object  Singleton {
    val name: String = "Dddd"
    fun hello() = println("hello")
}

class Outer {
    private constructor()
    companion object Loader{
        fun hello() {
            println(" Hello from companion object ")
        }
        fun get(): Outer = Outer()
    }

}

interface  ClickListender {
    fun click()
}

class View {
    fun setOnClichListender(listender: ClickListender) {
        //
    }
}


fun main() {

    val listen: ClickListender = object : ClickListender {
        override fun click() {

        }
    }

    val view = View()

    view.setOnClichListender(listen)

    view.setOnClichListender(object : ClickListender {
        override fun click() {
            TODO("ggggg")
        }
    })

    // val outer = Outer() // приватный конструктор

    val outer = Outer.get()
    Outer.Loader.hello()


    println(Singleton.name)
    Singleton.hello()

}