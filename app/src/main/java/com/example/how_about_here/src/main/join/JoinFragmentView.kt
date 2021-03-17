package com.example.how_about_here.src.main.join

import com.example.how_about_here.src.main.join.models.SignUpResponse
import com.example.how_about_here.src.main.join.models.UserResponse


interface JoinFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}