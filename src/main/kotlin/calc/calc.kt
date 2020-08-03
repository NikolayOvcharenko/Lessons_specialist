package calc

// переделка функции расширения
fun List<Int>.sum(): Int {
    var ret = 0
    for (i in this) ret += i
    return ret
}

fun isValidId(string: String): Boolean {
    return string.matches("""[a-zA-Z0-9]\w{3,}""".toRegex())
}

interface Animal {
    fun say()
}

class Goat : Animal {
    override fun say() = println("Beee!")
}

class Cow : Animal {
    override fun say() = println("Muuu!")
}

class Dog : Animal {
    override fun say() = println("Bark Gau!")
}

class Cat : Animal {
    override fun say() = println("Miau!")
}

// Фибоначи
fun fib(number: Int): Int {
    var last = 0
    var preLast = 0
    var rezult = 1
    for (i in 1..number) {
        rezult += preLast
        preLast = last
        last = rezult
    }
    return rezult
}

// interface Expr
sealed class Expr //
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
class Mul(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    is Mul -> eval(e.left) * eval(e.right)
    else -> throw IllegalAccessException("Uncnow expression")
}

fun main() {


    var b = StringBuilder("hello")
    b.lastCharOf = '!'
    println(b)
    /*  println(
          eval(
              Sum(
                  Num(2),
                  Mul(
                      Num(5),
                      Num(6)
                  )
              )
          )
      )

      val farm = listOf(Dog(),Cow(),Goat(),Cat())
      for(animal in farm) animal.say()

         println(isValidId("test11"))
         println(isValidId("te1"))
         println(isValidId("1221"))
         println(isValidId("test  11"))
         println(isValidId("_test11"))


         // нахождение числа фибоначчи
         println(fib(10))

         // расширение .print()
         val any = 123
         println(any.print())
         println("123".print())
         println(123f.print())
         val long: Long = 212
     */
}

fun Any.print(): String =
    when (this) {
        is String -> "String: $this"
        is Int -> "Int: $this"
        else -> "Don't know: $this"
    }

fun StringBuilder.lastCharOf() : Char = get(length - 1)

var StringBuilder.lastCharOf : Char
    get() = get(length - 1)
    set(value) = setCharAt(length - 1, value)