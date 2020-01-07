package com.goods.android.dictionary.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.goods.android.dictionary.MainActivity
import com.goods.android.dictionary.R
import com.goods.android.dictionary.databinding.EntryFragmentBinding
import com.goods.android.dictionary.model.DictionaryEntry
import java.lang.Exception

private const val TAG = "EntryFragment"

class EntryFragment : Fragment(){


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {//scoped to activity to share with SearchFragment
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
            val binding : EntryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.entry_fragment, container,false)
            binding.viewmodel = viewModel
            binding.lifecycleOwner = this

            viewModel.setUpMediator()
            return binding.root
        }
    }
