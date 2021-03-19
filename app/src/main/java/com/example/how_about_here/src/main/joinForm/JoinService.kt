package com.example.how_about_here.src.main.joinForm

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.joinForm.models.PostSignUpRequest
import com.example.how_about_here.src.main.joinForm.models.UserResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinService(val view: JoinFragmentView) {

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

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(JoinRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onPostSignUpSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

}
