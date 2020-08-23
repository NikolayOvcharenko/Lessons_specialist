package retrofit.dictionary

import retrofit.dictionary.json.DicJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexDicJsonService {
    @GET("/api/v1/dicservice.json/lookup?key=dict.1.1.20170402T202525Z.1ed8dd7c23205718.efda3a2c4bdf834b16909622280b20b0d60840a1")
// https://dictionary.yandex.net/api/v1/dicservice.json/lookup
    fun look(
        // @Query("key")
        // key: String,
        @Query("lang")
        lang: String,
        @Query("text")
        text: String
    ): Call<DicJson>
}