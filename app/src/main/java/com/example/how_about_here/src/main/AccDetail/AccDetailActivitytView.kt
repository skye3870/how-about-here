package com.example.how_about_here.src.main.AccDetail

import com.example.how_about_here.src.main.AccDetail.model.AccDetailResponse
import com.example.how_about_here.src.main.AccDetail.modelReviews.AccReviewsResponse


interface AccDetailActivitytView {

    /*fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)*/

    fun onSuccess(response: AccDetailResponse)
    fun onSuccessReview(response: AccReviewsResponse)

    fun onFailure(message: String)
}