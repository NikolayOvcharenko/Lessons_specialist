
class Box<T: Any> (t:T) {
    var value = t
}

class Bitmap

class Result<T>(val result: T?, val t: Throwable?)

fun <T> List<T>.getByNumbers(vararg args: Int): List<T> {
    val result = mutableListOf<T>()
    for (index in args) result.add(this[index])
    return result
}

fun main() {
    // val listOfNumber: List<Number> = listOf(1,2,3,4,5)
    // val listOfNumber: List<Number> = mutableListOf(1,2,3,4,5)
    //val mutableListOfNumber: MutableList<Number> = mutableListOf(1,2,3,4,5)
    val mutableListOfNumber: MutableList<out Number> = mutableListOf<Int>(1,2,3,4,5) // only read Int
    // mutableListOfNumber.add(6)


    val mutableListOfNumber1: MutableList<Number> = mutableListOf<Number>(1.33, 3.44)

    // val listOfInt: MutableList<Int> = mutableListOf<Number>(1, 44.5) // Считать только Int
    // val listOfInt: MutableList<in Int> = mutableListOf<Number>(1, 44.5) // only write Number!
    val listOfInt: MutableList<in Int> = mutableListOfNumber1

    listOfInt.add(232)
    println(listOfInt[0])



    val bitmap = Bitmap()
    val result = Result(bitmap, null)
    val throwable = Throwable("Error")
   // val error = Result(bitmap, throwable)
    val error = Result<Bitmap>(null, throwable)

    // val intBox = Box<Int>(1)
    val intBox = Box(1)
    val numberBox: Box<Number> = Box (2.333)
    // val nullBox = Box(null)

    val list = listOf(1, 2, 3, 4)
    // list[2] = 12

    val mutableList = mutableListOf(1, 2, 3, 4)
    mutableList.add(5)

    val list2 = listOf(1, 2, 3, 4)

    println(list == list2)

    val set = setOf<String>("one", "two", "tree") // linkedHeadset, HashSet SortetSet

    val map = mapOf(1 to "one", 2 to "two") // LinkedMap HashMap SortedMap

    val numberProcessor = Processor<Number>()
    numberProcessor.process(12.1111)

    println(
        isAny<String>(12)
    )
}

class Processor<T> {
    fun process(t: T) {

    }
}

inline fun <reified T> isAny(any: Any): Boolean = any is T // reified