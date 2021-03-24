package com.example.how_about_here.src.main.AccDetail

import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.joinForm.models.UserResponse


interface AccDetailActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: AccDetailResponse)

    fun onFailure(message: String)
}