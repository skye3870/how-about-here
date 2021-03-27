package com.example.how_about_here.src.main.AccDetail.modelReviews


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("AccommodationReply")
    val accommodationReply: List<Any>,
    @SerializedName("DATE")
    val dATE: String,
    val nickName: String,
    val rating: Int,
    val reviewIdx: Int,
    val reviewImage: List<Any>,
    val reviewText: String,
    val roomName: String
)