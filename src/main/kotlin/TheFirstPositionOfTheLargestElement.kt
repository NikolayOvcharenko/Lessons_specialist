import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var max = 0
    var line = 0
    var counter = 0
    while (scanner.hasNext()) {
        counter++
        val next = scanner.nextInt()
        if(next > max) {
            max = next
            line = counter
        }
    }
    println("$max $line")
}
