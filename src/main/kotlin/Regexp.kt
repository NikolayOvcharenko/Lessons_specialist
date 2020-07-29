fun main() {

    println(date("12 MAR 2020"))
    // val line = "abc 123 def"
    println(date("12 03 2020"))
    // val regexp = """.*\d{3}.*"""

    // val pattern = regexp.toRegex()

    // println(line.matches(pattern))

}

fun date (date: String) :Boolean {

    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

    val regexp = """\d{2} $month \d{4}"""

    return date.matches(regexp.toRegex())
}