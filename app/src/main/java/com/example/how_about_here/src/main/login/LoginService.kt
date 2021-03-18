package com.example.how_about_here.src.main.login

import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.joinForm.models.PostSignUpRequest
import com.example.how_about_here.src.main.login.models.PostUserLoginRequest
import com.example.how_about_here.src.main.login.models.SignUpResponse
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginFragmentView) {

    fun tryUserLogin(postUserLoginRequest: PostUserLoginRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        homeRetrofitInterface.postUsersLogin(postUserLoginRequest).enqueue(object : Callback<SignUpResponse>{


            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onGetUserLoginSuccess(response.body() as UsersLoginResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onGetUserLoginFailure(t.message?:"통신오류")
            }


        })
    }

}
