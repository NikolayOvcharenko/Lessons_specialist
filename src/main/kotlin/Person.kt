
public class Person (val name: String, var isMerried: Boolean = false)


fun main() {
    val max = Person("Max")
    println("${max.name} ${max.isMerried}")
}