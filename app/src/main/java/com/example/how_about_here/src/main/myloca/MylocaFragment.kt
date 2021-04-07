package com.example.how_about_here.src.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.how_about_here.R
import com.example.how_about_here.config.BaseFragment
import com.example.how_about_here.databinding.FragmentMyLocaBinding
import com.example.how_about_here.src.main.myloca.MylocaFragmentView
import com.example.how_about_here.src.main.myloca.MylocaService
import com.example.how_about_here.src.main.myloca.model.mylocaAdapter
import com.example.how_about_here.src.main.searchAccResult.SearchAccResultService
import com.example.how_about_here.src.main.searchAccResult.model.Result
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse
import com.softsquared.template.kotlin.src.main.search.recyclerview.SearchAdapter

class MylocaFragment :
    BaseFragment<FragmentMyLocaBinding>(FragmentMyLocaBinding::bind, R.layout.fragment_my_loca),
    MylocaFragmentView{

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            MylocaService(this).tryGetSearchAccResult(keyword = "강남")
        }

    override fun onSuccess(response: SearchAccResultResponse) {
        var SearchList: List<Result>? = response.result
        binding.rvMyloca.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMyloca.setHasFixedSize(true)
        binding.rvMyloca.adapter = SearchList?.let { mylocaAdapter(it) }
    }

    override fun onFailure(message: String) {

    }

}