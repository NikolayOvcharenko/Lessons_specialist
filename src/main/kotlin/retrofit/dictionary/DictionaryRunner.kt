package retrofit.dictionary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val retrofit: Retrofit = Retrofit.Builder()

    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(SimpleXmlConverterFactory.create())
    .build()

val retroJson: Retrofit = Retrofit.Builder()

    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val yandexDictionaryService = retrofit.create(YandexDictionaryService::class.java)
val yandexDicJsonService = retroJson.create(YandexDicJsonService::class.java)

fun main() {
    val responce = yandexDictionaryService.look("en-ru","fighter jet").execute()
    if(responce.isSuccessful) {
        val result = responce.body()
        println(
            result?.defs?.get(0)?.trs?.get(0)?.text
        )
    }

    val jsons = yandexDicJsonService.look("en-ru","fighter jet").execute()
    if (jsons.isSuccessful) {
        val res = jsons.body()
        println(
            res!!.def.get(0).tr.get(0).text
        //  res?.def?.get(0)?.tr?.get(0)?.text
        )
    }

}