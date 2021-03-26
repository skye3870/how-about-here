package com.example.how_about_here.src.main.searchAccResult

import com.example.how_about_here.src.main.roomDetail.model.RoomDetailResponse
import com.example.how_about_here.src.main.searchAccResult.model.SearchAccResultResponse


interface SearchAccResultFragmentView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: SearchAccResultResponse)

    fun onFailure(message: String)
}