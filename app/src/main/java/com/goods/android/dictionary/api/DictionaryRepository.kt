package com.goods.android.dictionary.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.goods.android.dictionary.model.DictionaryEntry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "DictionaryFetcher"

class DictionaryRepository {
    private val api : API

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://wordsapiv1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }

    fun fetchContents(searchQuery : String) : MutableLiveData<DictionaryEntry> { //returns a mutable live data object that is "filled in later"
        val responseLiveDictionaryEntry : MutableLiveData<DictionaryEntry> = MutableLiveData()
        val dictionaryEntryRequest: Call<DictionaryEntry> = api.getDefinition(searchQuery)

        dictionaryEntryRequest.enqueue(object : Callback<DictionaryEntry> {
            override fun onFailure(call: Call<DictionaryEntry>, t: Throwable) {
                Log.e(TAG, "Failed to fetch data", t)
            }

            override fun onResponse(
                call: Call<DictionaryEntry>,
                response: Response<DictionaryEntry>
            ) {
                Log.e(TAG, "Response Received")
                var dictionaryEntry = response.body()
                responseLiveDictionaryEntry.postValue(dictionaryEntry)

            }
        })

        return responseLiveDictionaryEntry
    }
}