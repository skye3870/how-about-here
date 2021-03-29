package com.example.how_about_here.src.main.reserveCheck

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.reserveCheck.model.ReserveCheckResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReserveCheckService(val view: ReserveCheckActivitytView) {

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

    fun tryGetReserveCheck(){
        val reserveCheckRetrofitInterface = ApplicationClass.sRetrofit.create(ReserveCheckRetrofitInterface::class.java)
        reserveCheckRetrofitInterface.getReserveCheck().enqueue(object : Callback<ReserveCheckResponse>{
            override fun onResponse(call: Call<ReserveCheckResponse>, response: Response<ReserveCheckResponse>) {
                view.onSuccess(response.body() as ReserveCheckResponse)
            }

            override fun onFailure(call: Call<ReserveCheckResponse>, t: Throwable) {
                view.onFailure(t.message ?: "통신 오류")
            }


        })
    }


}

