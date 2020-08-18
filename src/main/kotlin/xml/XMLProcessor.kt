package xml

import org.simpleframework.xml.core.Persister
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

val xlm = """
    <catalog>
       <book id="bk101">
          <author>Gambardella, Matthew</author>
          <title>XML Developer's Guide</title>
          <genre>Computer</genre>
          <price>44.95</price>
          <publish_date>2000-10-01</publish_date>
          <description>An in-depth look at creating applications with XML.</description>
       </book>
       <book id="bk102">
          <author>Ralls, Kim</author>
          <title>Midnight Rain</title>
          <genre>Fantasy</genre>
          <price>5.95</price>
          <publish_date>2000-12-16</publish_date>
          <description>A former architect battles corporate zombies.</description>
       </book>
    </catalog>
""".trimIndent()


fun main() {
    // 2 типа парсеров SAX-потоковый и DOM-объектная древовидная модель(держит все в памяти - ограничен размерами памяти большие потери)

    val serializer = Persister()
    val catalog = serializer.read(Catalog::class.java, xlm)
    println(catalog.books?.get(1)?.description)

/*
    val buildFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = buildFactory.newDocumentBuilder()
    val doc = documentBuilder.parse(InputSource(StringReader(xlm)))
    val books = doc.getElementsByTagName("book")
    for (index in 0 until books.length) {
        val book = books.item(index)
        println(book.attributes.getNamedItem("id"))
        println(book.childNodes.item(1).textContent)
    }

 */
}