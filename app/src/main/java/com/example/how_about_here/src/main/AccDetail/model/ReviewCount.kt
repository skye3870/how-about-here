package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class ReviewCount(
    @SerializedName("COUNT(R.reviewIdx)")
    val cOUNTRReviewIdx: Int
)