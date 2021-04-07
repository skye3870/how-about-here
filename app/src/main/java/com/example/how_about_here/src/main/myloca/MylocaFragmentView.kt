package com.example.how_about_here.src.main.myloca

import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse


interface MylocaFragmentView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: SearchAccResultResponse)

    fun onFailure(message: String)
}