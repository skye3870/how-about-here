package com.example.how_about_here.src.main.AccDetail.modelReviews


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("Review")
    val review: List<Review>,
    @SerializedName("ReviewInfo")
    val reviewInfo: List<ReviewInfo>
)