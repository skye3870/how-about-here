package com.example.how_about_here.src.main.search

import android.os.Bundle

import android.view.View

import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment

import com.example.how_about_here.databinding.FragmentSearchAccBinding


class SearchAccFragment :
        BaseFragment<FragmentSearchAccBinding>(FragmentSearchAccBinding::bind, R.layout.fragment_search_acc) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
검색하면 프레그 먼트 이동

    }
}