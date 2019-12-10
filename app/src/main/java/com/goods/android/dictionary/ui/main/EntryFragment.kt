package com.goods.android.dictionary.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import com.goods.android.dictionary.R
import com.goods.android.dictionary.databinding.EntryFragmentBinding

class EntryFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<EntryFragmentBinding>(inflater, R.layout.entry_fragment, container,false)
        return binding.root
    }
}