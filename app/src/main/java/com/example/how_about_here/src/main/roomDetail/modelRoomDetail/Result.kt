package com.example.how_about_here.src.main.roomDetail.modelRoomDetail


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("ExtraInfo")
    val extraInfo: String,
    @SerializedName("Facility")
    val facility: String,
    @SerializedName("Image")
    val image: List<String>,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Int,
    @SerializedName("RefundInfo")
    val refundInfo: List<String>,
    @SerializedName("RoomInfo")
    val roomInfo: List<String>
)