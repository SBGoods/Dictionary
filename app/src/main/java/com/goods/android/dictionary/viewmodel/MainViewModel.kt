package com.goods.android.dictionary.viewmodel

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.goods.android.dictionary.R
import com.goods.android.dictionary.api.DictionaryFetcher
import com.goods.android.dictionary.model.DictionaryEntry

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    var mediatorLiveData : MediatorLiveData<DictionaryEntry> = MediatorLiveData()
    var dictionaryEntryLiveData : MutableLiveData<DictionaryEntry> = MutableLiveData()
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