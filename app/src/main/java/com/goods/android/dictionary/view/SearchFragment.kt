package com.goods.android.dictionary.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.goods.android.dictionary.R
import com.goods.android.dictionary.databinding.SearchFragmentBinding
import com.goods.android.dictionary.viewmodel.MainViewModel
import java.lang.Exception

private const val TAG = "SearchFragment"

class SearchFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

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
        binding.searchfragment = this

        return binding.root
    }

    fun searchButtonClick(view : View) {
        view.setOnClickListener {
            viewModel.fetchDefinitions()
            view.findNavController().navigate(R.id.action_searchFragment_to_entryFragment)
        }
    }

}
