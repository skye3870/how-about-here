package com.example.how_about_here.src.main.login

import com.example.how_about_here.src.main.joinForm.models.UserResponse
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


interface LoginActivityView {

    fun onGetUserLoginSuccess(response: UsersLoginResponse)
    fun onGetUserLoginFailure(message:String)
}