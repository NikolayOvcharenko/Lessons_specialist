
/*
val convert: (String) -> Int = {
    val number = try {
        value.toInt()
    } catch (e:NumberFormatException) {
        val keyMap = mapOf("abc" to 2, "def" to 3)
        keyMap.filter { it.key.contains(value.toLowerCase()) }.map {
            it.value }.first()
        }
    if (number < 10) {
        number
    } else {
        sentinel // RxJava2 does not allow null in stream, so return sentinel value
    }
}

 */