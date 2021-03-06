package com.example.how_about_here.src.main.searchAccResult

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchAccResultService(val view: SearchAccResultFragmentView) {


    fun tryGetSearchAccResult(keyword: String) {
        val searchAccResultRetrofitInterface = ApplicationClass.sRetrofit.create(SearchAccResultRetrofitInterface::class.java)
        searchAccResultRetrofitInterface.getSearch(keyword).enqueue(object : Callback<SearchAccResultResponse> {

                override fun onResponse(call: Call<SearchAccResultResponse>, response: Response<SearchAccResultResponse>) {
                   view.onSuccess(response.body() as SearchAccResultResponse)
                }

                override fun onFailure(call: Call<SearchAccResultResponse>, t: Throwable) {
                    view.onFailure(t.message ?: "통신 오류")
                }


            })
    }

}
