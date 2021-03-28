package com.example.how_about_here.src.main.roomDetail.modelReservationResult


import com.google.gson.annotations.SerializedName

data class ReservationResultResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String
)