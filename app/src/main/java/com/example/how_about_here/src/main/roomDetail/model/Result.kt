package com.example.how_about_here.src.main.roomDetail.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("Image")
    val image: List<Image>,
    val room: Room
)