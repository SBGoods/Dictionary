package com.goods.android.dictionary.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.goods.android.dictionary.api.DictionaryFetcher
import com.goods.android.dictionary.model.DictionaryEntry

class MainViewModel : ViewModel() {
    lateinit var dictionaryEntryLiveData : LiveData<DictionaryEntry>


    fun fetchDefinitions(input : String){
        dictionaryEntryLiveData = DictionaryFetcher().fetchContents(input)
    }
}
