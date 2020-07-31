package strings

fun String.lastCharOf(): Char = this.get(this.length - 1)

fun String.allMatchesOf(patt: String): List<String> {
    val ret = mutableListOf<String>()
    val found = patt.toRegex().findAll(this)
    for (result in found) ret.add(result.value)
    return ret
}

fun List<String>.firstElementOf(): String = get(0)
fun main() {
    println("JAva".lastCharOf())
    println(listOf("one", "two").firstElementOf())
    val html = "<html><head>hello</head><h1>heading</h1><p>Greet!<br></html>"
    val regexp = """<[^>/]+>"""
    html.allMatchesOf(regexp).forEach { println(it) }
}