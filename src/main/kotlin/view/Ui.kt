package view

import JavaClickListener
import JavaView

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 22),
    Person("Boby", 31),
    Person("Carla", 42)
)

fun hi() = println("Hi")

fun Person.isAdult() = age >=18

fun main() {

    val adult = Person::isAdult

    val create = ::Person
    val max = create("Max", 23)
    val maxAge = max::age

    val hello = ::hi
    run(hello)

    val personAge = Person::age

    var counter = 0

    people.forEach {
        counter++
    }
    println(counter)

    val ageSort = { p: Person -> p.age }

    println(
        // people.minBy { p -> p.age }
        // people.minBy { it.age }
        // people.minBy(Person::age)
        people.minBy(ageSort)
    )


    val javaView = JavaView()
    javaView.setOnClickListener(
        object : JavaClickListener {
            override fun onClick(view: JavaView?) {}

        }
    )

    javaView.setOnClickListener { view -> print("hello") }
}