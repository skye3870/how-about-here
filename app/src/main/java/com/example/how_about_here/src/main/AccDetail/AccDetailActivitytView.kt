package com.example.how_about_here.src.main.AccDetail

import com.example.how_about_here.src.main.AccDetail.modelAccDetail.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.modelReviews.AccReviewsResponse
import com.example.how_about_here.src.main.roomDetail.modelReservationResult.ReservationResultResponse


interface AccDetailActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: AccDetailResponse)
    fun onSuccessReview(response: AccReviewsResponse)
    fun onFailure(message: String)



}