package com.example.how_about_here.src.main.AccDetail.modelReviews


import com.google.gson.annotations.SerializedName

data class ReviewInfo(
    val average: Double,
    val counting: Int,
    @SerializedName("Reply")
    val reply: Int
)