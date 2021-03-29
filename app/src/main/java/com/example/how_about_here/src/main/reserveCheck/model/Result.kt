package com.example.how_about_here.src.main.reserveCheck.model


import com.google.gson.annotations.SerializedName

data class Result(
    val acmdName: String,
    val checkIn: String,
    val checkOut: String,
    @SerializedName("Image")
    val image: String,
    val roomName: String
)