package com.example.how_about_here.src.main.login

import com.example.how_about_here.src.main.joinForm.models.SignUpResponse
import com.example.how_about_here.src.main.joinForm.models.UserResponse
import com.example.how_about_here.src.main.login.models.UsersLoginResponse


interface LoginFragmentView {
    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)
    fun onGetUserLoginSuccess(response: UsersLoginResponse)
    fun onGetUserLoginFailure(message:String)
}