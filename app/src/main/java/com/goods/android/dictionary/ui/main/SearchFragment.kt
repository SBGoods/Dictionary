package com.goods.android.dictionary.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.goods.android.dictionary.api.Api
import com.goods.android.dictionary.R
import com.goods.android.dictionary.api.DictionaryFetcher
import com.goods.android.dictionary.databinding.SearchFragmentBinding
import com.goods.android.dictionary.model.DictionaryEntry
import kotlinx.android.synthetic.main.search_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "SearchFragment"

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<SearchFragmentBinding>(inflater, R.layout.search_fragment, container, false)

        binding.search = resources.getString(R.string.search_button)
//        binding.searchButton.setOnClickListener {  View.OnClickListener{
//                it ->
//            Log.d(TAG, "button pressed")
//            viewModel.fetchDefinitions(search_bar.editableText.toString())
////            viewModel.dictionaryEntryLiveData.observe(
////                viewLifecycleOwner,
////                Observer { dictionaryEntry -> Log.d(TAG, "Response Received A: $dictionaryEntry") }
////            )
//        } }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }

}
