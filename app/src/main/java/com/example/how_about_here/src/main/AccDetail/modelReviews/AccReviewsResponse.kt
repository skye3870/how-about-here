package com.example.how_about_here.src.main.AccDetail.modelReviews


import com.google.gson.annotations.SerializedName

data class AccReviewsResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)