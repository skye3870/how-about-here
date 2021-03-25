package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class Room(
    val extraInfo: String,
    val price: Int,
    @SerializedName("RoomInformation")
    val roomInformation: String,
    val roomName: String,
    val roomIdx : Int
)