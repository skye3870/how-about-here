package com.example.how_about_here.src.main.AccDetail.model


import com.google.gson.annotations.SerializedName

data class Result(
    val address: Address,
    @SerializedName("Facility")
    val facility: List<Facility>,
    @SerializedName("Image")
    val image: List<Image>,
    val location: List<Location>,
    val name: Name,
    @SerializedName("NearInfo")
    val nearInfo: NearInfo,
    val rating: Rating,
    @SerializedName("RefundInfo")
    val refundInfo: RefundInfo,
    val reviewCount: ReviewCount,
    val room: List<Room>
)