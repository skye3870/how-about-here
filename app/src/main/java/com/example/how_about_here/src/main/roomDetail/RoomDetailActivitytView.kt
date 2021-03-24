package com.example.how_about_here.src.main.roomDetail

import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse


interface RoomDetailActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: RoomDetailResponse)

    fun onFailure(message: String)
}