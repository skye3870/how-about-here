package com.example.how_about_here.src.main.searchAccResult

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentSearchAccResultBinding
import com.example.how_about_here.src.main.AccDetail.modelAccDetail.AccFacilityAdapter
import com.example.how_about_here.src.main.AccDetail.modelAccDetail.Facility
import com.example.how_about_here.src.main.searchAccResult.model.Result
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse
import com.softsquared.template.kotlin.src.main.search.recyclerview.SearchAdapter


class SearchAccResultFragment :
        BaseFragment<FragmentSearchAccResultBinding>(FragmentSearchAccResultBinding::bind, R.layout.fragment_search_acc_result),
        SearchAccResultFragmentView  {

        var keyword : String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        keyword = arguments?.getString("keyword").toString()

        // Intent.getStringExtra("keyword").toString()
        //
        SearchAccResultService(this).tryGetSearchAccResult(keyword = keyword!!)


    }

    override fun onSuccess(response: SearchAccResultResponse) {
        var SearchList: List<Result>? = response.result
        binding.rvSearch.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvSearch.setHasFixedSize(true)
        binding.rvSearch.adapter = SearchList?.let { SearchAdapter(it) }

        binding.searchKeyword.text=keyword
    }

    override fun onFailure(message: String) {

    }


}



