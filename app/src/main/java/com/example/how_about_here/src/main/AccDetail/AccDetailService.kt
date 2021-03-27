package com.example.how_about_here.src.main.AccDetail

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.modelReviews.AccReviewsResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccDetailService(val view: AccDetailActivitytView) {

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

    fun tryGetAccDetail(getAccDetailRequest: Int){
        val accDetailRetrofitInterface = ApplicationClass.sRetrofit.create(AccRetrofitInterface::class.java)
        accDetailRetrofitInterface.getAccDetail(getAccDetailRequest).enqueue(object : Callback<AccDetailResponse>{

            override fun onResponse(call: Call<AccDetailResponse>, response: Response<AccDetailResponse>) {
                view.onSuccess(response.body() as AccDetailResponse)
            }

            override fun onFailure(call: Call<AccDetailResponse>, t: Throwable) {
                view.onFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetAccReviews(getAccReviewsRequest: Int){
        val accReviewsRetrofitInterface = ApplicationClass.sRetrofit.create(AccRetrofitInterface::class.java)
        accReviewsRetrofitInterface.getAccReviews(getAccReviewsRequest).enqueue(object : Callback<AccReviewsResponse>{

            override fun onResponse(call: Call<AccReviewsResponse>, response: Response<AccReviewsResponse>) {
                view.onSuccessReview(response.body() as AccReviewsResponse)
            }

            override fun onFailure(call: Call<AccReviewsResponse>, t: Throwable) {
                view.onFailure(t.message ?: "통신 오류")
            }


        })
    }

}

