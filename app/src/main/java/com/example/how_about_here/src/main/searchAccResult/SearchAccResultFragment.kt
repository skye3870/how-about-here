package com.example.how_about_here.src.main.searchAccResult

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.View

import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentSearchAccResultBinding
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse


class SearchAccResultFragment :
        BaseFragment<FragmentSearchAccResultBinding>(FragmentSearchAccResultBinding::bind, R.layout.fragment_search_acc_result),
        SearchAccResultFragmentView  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val keyword = Intent.getStringExtra("keyword").toString()
        //
    // SearchAccResultService(Context).tryGetSearchAccResult(keyword)


    }

    override fun onSuccess(response: SearchAccResultResponse) {

    }

    override fun onFailure(message: String) {

    }


}



