package com.goods.android.dictionary.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.goods.android.dictionary.MainActivity
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
import java.lang.Exception

private const val TAG = "SearchFragment"

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = activity?.run { //scoped to activity to share with EntryFragment
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val binding = DataBindingUtil.inflate<SearchFragmentBinding>(inflater, R.layout.search_fragment, container, false)
        binding.viewmodel = viewModel
        binding.search = resources.getString(R.string.search_button)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }

}
