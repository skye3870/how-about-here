package com.example.how_about_here.src.main.login

import android.content.ContentValues.TAG
import android.util.Log
import com.example.how_about_here.config.ApplicationClass
import com.example.how_about_here.src.main.login.models.PostUserLoginRequest
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {

    fun tryUserLogin(postUserLoginRequest: PostUserLoginRequest){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postUsersLogin(postUserLoginRequest).enqueue(object : Callback<UsersLoginResponse>{


            override fun onResponse(call: Call<UsersLoginResponse>, response: Response<UsersLoginResponse>) {
                view.onGetUserLoginSuccess(response.body() as UsersLoginResponse)


            }

            override fun onFailure(call: Call<UsersLoginResponse>, t: Throwable) {
                view.onGetUserLoginFailure(t.message?:"통신오류")
                Log.d("2222222222222222","${t.message}")
            }


        })
    }

}
