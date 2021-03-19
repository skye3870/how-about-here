package com.example.how_about_here.src.main.joinForm

import com.example.how_about_here.src.main.joinForm.models.UserResponse


interface JoinFragmentView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onPostSignUpSuccess(response: UserResponse)

    fun onPostSignUpFailure(message: String)
}