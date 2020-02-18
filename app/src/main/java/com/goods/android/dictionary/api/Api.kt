package com.goods.android.dictionary.api
import com.goods.android.dictionary.model.DictionaryEntry
import retrofit2.Call;
import retrofit2.http.*


//const val API_KEY = "206abaf31dmshf796be5f8468a0ap1484fcjsnc444078deb88"
//"https://wordsapiv1.p.rapidapi.com/words/weather/definitions")

interface Api {
    @Headers(
        "x-rapidapi-host: wordsapiv1.p.rapidapi.com",
        "x-rapidapi-key: 206abaf31dmshf796be5f8468a0ap1484fcjsnc444078deb88"
    )
    @GET("/words/{word}/definitions")
    fun getDefinition(@Path("word") word: String): Call<DictionaryEntry>
}