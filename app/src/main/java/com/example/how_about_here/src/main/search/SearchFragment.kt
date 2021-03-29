package com.example.how_about_here.src.main.search

import android.os.Bundle
import android.view.View
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentSearchBinding
import com.example.how_about_here.src.main.searchAcc.SearchAccFragment
import com.example.how_about_here.src.main.searchActivity.SearchActivityFragment

class SearchFragment :
        BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
                .replace(R.id.reserve_viewpadger, SearchAccFragment())
                .commitAllowingStateLoss()

            binding.imageButtonAcc.setOnClickListener(){
                childFragmentManager.beginTransaction()
                    .replace(R.id.reserve_viewpadger, SearchAccFragment())
                    .commitAllowingStateLoss()
            }
            binding.imageButtonActivity.setOnClickListener(){
                childFragmentManager.beginTransaction()
                        .replace(R.id.reserve_viewpadger, SearchActivityFragment())
                        .commitAllowingStateLoss()
            }
    }
}