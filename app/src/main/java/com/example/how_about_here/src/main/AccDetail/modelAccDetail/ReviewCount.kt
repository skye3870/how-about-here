package com.example.how_about_here.src.main.AccDetail.modelAccDetail


import com.google.gson.annotations.SerializedName

data class ReviewCount(
    @SerializedName("COUNT(R.reviewIdx)")
    val cOUNTRReviewIdx: Int
)