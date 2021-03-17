package com.example.how_about_here.src.main.search

import android.os.Bundle

import android.view.View

import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment

import com.example.how_about_here.databinding.FragmentSearchAccBinding
import com.example.how_about_here.databinding.FragmentSearchActivityBinding


class SearchActivityFragment :
        BaseFragment<FragmentSearchActivityBinding>(FragmentSearchActivityBinding::bind, R.layout.fragment_search_activity) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}