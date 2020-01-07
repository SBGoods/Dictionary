package com.goods.android.dictionary.ui.main

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.goods.android.dictionary.R
import com.goods.android.dictionary.api.DictionaryFetcher
import com.goods.android.dictionary.model.Definition
import com.goods.android.dictionary.model.DictionaryEntry

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    var counter = 0
    var mediatorLiveData : MediatorLiveData<DictionaryEntry> = MediatorLiveData()
    var dictionaryEntryLiveData : MutableLiveData<DictionaryEntry> = MutableLiveData(DictionaryEntry(
        listOf(Definition("def", "part")), "example"))
    var searchQuery = ""


    fun fetchDefinitions(input : String){
        dictionaryEntryLiveData = DictionaryFetcher().fetchContents(input)

    }

    fun setUpMediator(){
        mediatorLiveData.addSource(dictionaryEntryLiveData)
        {
            mediatorLiveData.value = it
        }
    }

    @BindingAdapter("android:onClick")
    fun searchButtonClick(view : View){
        view.setOnClickListener {
            fetchDefinitions(searchQuery)
            view.findNavController().navigate(R.id.action_searchFragment_to_entryFragment)
        }

    }
}
