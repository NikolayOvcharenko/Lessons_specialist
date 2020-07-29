fun main() {
    for (data in 0..20) println(FizzBuzz(data))
}

fun FizzBuzz(data: Int) =
    when {
        (data % 5 == 0 && data % 3 == 0) -> "FizzBuzz"
        (data % 5 == 0) -> "Buzz"
        (data % 3 == 0) -> "Fizz"
        else -> data.toString()
    }
