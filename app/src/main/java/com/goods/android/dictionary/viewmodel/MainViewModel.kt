package com.goods.android.dictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goods.android.dictionary.api.DictionaryRepository
import com.goods.android.dictionary.model.DictionaryEntry

class MainViewModel : ViewModel() {
    var dictionaryEntryLiveData : MutableLiveData<DictionaryEntry> = MutableLiveData()
    var searchQuery = ""

    fun fetchDefinitions(){
        dictionaryEntryLiveData = DictionaryRepository().fetchContents(searchQuery)
    }

}
