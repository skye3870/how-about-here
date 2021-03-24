package com.example.how_about_here.src.main.roomDetail.model


import com.google.gson.annotations.SerializedName

data class RoomDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)