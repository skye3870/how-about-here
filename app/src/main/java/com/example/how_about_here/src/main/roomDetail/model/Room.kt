package com.example.how_about_here.src.main.roomDetail.model


import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("ExtraInfo")
    val extraInfo: String,
    @SerializedName("Facility")
    val facility: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Int,
    val refundInfo: String,
    @SerializedName("RoomInfo")
    val roomInfo: String
)