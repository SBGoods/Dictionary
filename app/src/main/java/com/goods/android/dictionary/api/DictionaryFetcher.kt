package com.goods.android.dictionary.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.goods.android.dictionary.model.DictionaryEntry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "DictionaryFetcher"

class DictionaryFetcher {
    private val api : Api

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://wordsapiv1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        api = retrofit.create(Api::class.java)
    }

    fun fetchContents(searchQuery : String) : LiveData<DictionaryEntry> {

        val responseLiveDictionaryEntry : MutableLiveData<DictionaryEntry> = MutableLiveData()

        val DictionaryEntryRequest: Call<DictionaryEntry> = api.getDefinition(searchQuery)

        DictionaryEntryRequest.enqueue(object : Callback<DictionaryEntry> {
            override fun onFailure(call: Call<DictionaryEntry>, t: Throwable) {
                Log.e(TAG, "Failed to fetch data", t)
            }

            override fun onResponse(
                call: Call<DictionaryEntry>,
                response: Response<DictionaryEntry>
            ) {
                Log.e(TAG, "Response Received")
                val dictionaryEntry: DictionaryEntry? = response.body()
                responseLiveDictionaryEntry.value = dictionaryEntry
                System.out.println(dictionaryEntry?.toString())
            }
        })
        return responseLiveDictionaryEntry
    }
}