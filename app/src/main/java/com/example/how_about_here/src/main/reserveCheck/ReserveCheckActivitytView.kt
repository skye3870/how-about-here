package com.example.how_about_here.src.main.reserveCheck

import com.example.how_about_here.src.main.reserveCheck.model.ReserveCheckResponse


interface ReserveCheckActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: ReserveCheckResponse)

    fun onFailure(message: String)



}