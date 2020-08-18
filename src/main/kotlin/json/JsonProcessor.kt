package json

import com.google.gson.Gson
import org.json.JSONObject

val json = """
     {
        "owner": "John Smith",
        age: 55,
        "books":[
           {
              "id":"444",
              "language":"C",
              "edition":"First",
              "author":"Dennis Ritchie "
           },
           {
              "id":"555",
              "language":"C++",
              "edition":"second",
              "author":" Bjarne Stroustrup "
           }
        ]
     }
 """.trimIndent()


fun main() {
    val gson = Gson()
    val owner: BookOwner = gson.fromJson(json, BookOwner::class.java)
    println(owner.owner)
    println(owner.books[1].author)
    println(gson.toJson(owner))

    /*
    val obj = JSONObject(json)

    println(obj.getString("owner"))
    val books = obj.getJSONArray("books")
    // books.length()
    println((books[1] as JSONObject).getString("author"))

    */
}