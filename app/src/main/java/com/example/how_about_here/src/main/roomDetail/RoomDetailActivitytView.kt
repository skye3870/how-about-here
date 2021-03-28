package com.example.how_about_here.src.main.roomDetail

import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultResponse
import com.example.how_about_here.src.main.roomDetail.modelRoomDetail.RoomDetailResponse


interface RoomDetailActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: RoomDetailResponse)
    fun onSuccessResult(response: ReservationResultResponse)
    fun onFailure(message: String)
}