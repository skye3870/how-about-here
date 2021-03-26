package com.example.how_about_here.src.main.searchAccResult

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchAccResultService(val view: SearchAccResultFragmentView) {

    /*fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(JoinRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }*/

    fun tryGetSearchAccResult(keyword: String) {
        val searchAccResultRetrofitInterface =
            ApplicationClass.sRetrofit.create(SearchAccResultRetrofitInterface::class.java)
        searchAccResultRetrofitInterface.getSearch(keyword)
            .enqueue(object : Callback<SearchAccResultResponse> {

                override fun onResponse(call: Call<SearchAccResultResponse>, response: Response<SearchAccResultResponse>) {
                   view.onSuccess(response.body() as SearchAccResultResponse)
                }

                override fun onFailure(call: Call<SearchAccResultResponse>, t: Throwable) {
                    view.onFailure(t.message ?: "통신 오류")
                }


            })
    }

}
