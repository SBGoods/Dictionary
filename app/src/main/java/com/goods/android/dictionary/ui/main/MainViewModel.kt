package com.goods.android.dictionary.ui.main

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.goods.android.dictionary.R
import com.goods.android.dictionary.api.DictionaryFetcher
import com.goods.android.dictionary.model.DictionaryEntry

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    lateinit var dictionaryEntryLiveData : LiveData<DictionaryEntry>
    var searchQuery = ""

    fun fetchDefinitions(input : String){
        this.dictionaryEntryLiveData = DictionaryFetcher().fetchContents(input)

    }

    @BindingAdapter("android:onClick")
    fun searchButtonClick(view : View){
        view.setOnClickListener {
            fetchDefinitions(searchQuery)
            view.findNavController().navigate(R.id.action_searchFragment_to_entryFragment)
            Log.d(TAG, "button pressed")
        }

    }
}
